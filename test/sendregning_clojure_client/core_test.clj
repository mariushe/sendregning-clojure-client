(ns sendregning-clojure-client.core-test
  (:require [clojure.test :refer :all]
            [sendregning-clojure-client.core :refer :all]))

(deftest test-add-line
  (testing "add one invoice line"
    (is (= {:lines '({:qty 1
                      :description "desc"
                      })} 
           (add-line {:lines '()} 1 "desc")))))

(deftest test-add-two-lines
  (testing "add two invoice lines"
    (is (= {:lines '({:qty 1
                      :description "desc1"} 
                     {:qty 2
                      :description "desc2"}
                     )}
           (add-line {:lines '({:qty 1 :description "desc1"})} 
                     2                     
                     "desc2")))))

(deftest test-add-two-with-arrow
  (testing "add two invoice lines with arrow syntax"
    (is (= {:lines '({:qty 1
                      :description "desc1"}
                     {:qty 2
                      :description "desc2"})}
           (-> {:lines '()}
               (add-line 1 "desc1")
               (add-line 2 "desc2"))))))

(deftest test-add-recipient
  (testing "add recipient"
    (is (= {:recipient {:name "John Doe"
                        :address {:address1 "Gjerdrums vei 4"
                                  :zip "0484"
                                  :city "Oslo"
                                  :country "NORGE"}}}
           (add-recipient {} "John Doe" {:address "Gjerdrums vei 4"
                                         :zip "0484"
                                         :city "Oslo"
                                         :country "NORGE"})))))

(deftest test-update-recipient
  (testing "update recipient"
    (is (= {:recipient {:name "John Doe"
                        :address {:address1 "Gjerdrums vei 4"
                                  :zip "0484"
                                  :city "Oslo"
                                  :country "NORGE"}}}
           (add-recipient {:recipient {:name "Old one"}}
                          "John Doe"
                          {:address "Gjerdrums vei 4"
                           :zip "0484"
                           :city "Oslo"
                           :country "NORGE"})))))

(run-tests)
