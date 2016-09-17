(ns clojurebridge-turtle.walk
  (:use clojure.repl)
  (:use clojurebridge-turtle.core))
(init)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; On NightCode, click Run with REPL followed by Reload File
;; for the first time. If REPL has already started, click
;; Reload File to run this code.
;;
;; Once a turtle (small triangle) appears in the center of window,
;; type code in REPL.
;;
;; Alternatively, you may type code in this editor. To evaluate:
;; - pieces of code: select code fragment and Reload Selection
;; - whole file: click Reload Fil
;;
;; [Exercise]
;; write some functions under these comment lines
;; and evalute those
;;
;; for example
;; (forward 30)
;; (right 90)
;; (forward 30)
;; (right 90)
;;
;; see how the turtle walks
;;


(forward 10)

#_(defn parse-commands [state]
  (println "hello")
   (let [ empty-commands (empty? (:commands state))
          plus (= (str(first (:commands state)) "+"))
          minus (= (str(first (:commands state)) "-"))
          ;_ (println (str "conditions: " \newline))
          ;_ (clojure.pprint/pprint {:commands commands
          ;                          :empty-commands empty-commands
          ;                          :plus plus
          ;                          :minus minus
          ;                          :turtles (turtle-names)})
         _ (cond
              empty-commands nil
              plus (doseq [n (turtle-names)] (right n (n angles)))
              minus (doseq [n (turtle-names)] (left n (n angles)))
              :else (doseq [n (turtle-names)] (forward n 5)) )]))


;(defn parse-commands [commands angle]
;(cond
;(empty? commands) ()
;(= (str(first commands)) "+") ((right :neo 90) (parse-commands (rest commands) 20))
;(= (str(first commands)) "-") ((left :neo 90) (parse-commands (rest commands) 20))
;:else ((forward :neo 15) (parse-commands (rest commands) 20))

