(ns welcometoclojurebridge.core
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [clojurebridge-turtle.walk]))

(def angle-speed 0.05)
(def color-speed 0.15)


(defn setup []
  (q/frame-rate 1)
  (q/color-mode :hsb)
  (q/text-font (q/create-font "resources/SourceCodePro-Regular.ttf" 36 true))
  (q/background 0)                    ;; Turn on anti-aliasing

  {:logo (q/load-image "logo.png")
   :background (q/load-image "background.png")
   :color 0
   :angle 0})

(defn update-state [state]
  (-> state
      (update-in [:color] #(mod (+ % color-speed) 255))
      (update-in [:angle] + angle-speed)))

(defn draw-state [state]
  (q/background-image (:background state))

  (let [angle (:angle state)
        x (* 180 (q/cos angle))
        y (* 110 (q/sin angle))]
    (q/fill (mod (:color state) 80) (mod (:color state) 180) (mod (:color state) 150))
    (q/text "Welcome to"     190 (min 180 (+ 190 y)))
    (q/text "You are ready to code!" 80 (max 330 (+ 330 y)))

    (q/with-translation [(/ (q/width) 2)
                         (/ (q/height) 2)]
      (q/image (:logo state) (- x 60) (- y 60) 120 120))))

(def angles
   {
     :trinity 45
     :neo 90
    :oracle 120
    :cypher 60})



(q/defsketch welcometoclojurebridge
  :title "Welcome To ClojureBridge!"
  :size :fullscreen 
  :setup setup
  :update update-state
  :draw draw-state
  :features [:keep-on-top :present]
  :middleware [m/fun-mode])

;;
;; photo credit http://wall.alphacoders.com/big.php?i=345953
;;
