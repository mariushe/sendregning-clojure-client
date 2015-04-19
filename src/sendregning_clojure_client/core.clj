(ns sendregning-clojure-client.core)

(defn prep-new-invoice []
  {:lines '()})

(defn add-line [inv qty desc]
  (merge-with concat                      
              inv
              {:lines 
               (list {:qty qty
                      :description desc})}))

(defn add-recipient [inv name address]
  (assoc inv :recipient {:name name
                         :address (rename-address address)}))

(defn rename-address [address] 
  (rename-keys address {:address :address1}))
