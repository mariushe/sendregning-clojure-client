(ns sendregning-clojure-client.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn prep-new-invoice []
  {:lines '()})

(defn add-line [inv qty desc]
  (merge-with conj 
              inv 
              {:lines 
               {:qty qty}}))

