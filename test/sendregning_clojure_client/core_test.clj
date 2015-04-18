(ns sendregning-clojure-client.core-test
  (:require [clojure.test :refer :all]
            [sendregning-clojure-client.core :refer :all]))


(deftest test-add-line
  (testing "add one invoice line"
    (is (= {:lines '({:qty 1})} 
           (add-line {:lines '()} 1 "desc")))))

(deftest test-add-two-lines
  (testing "add two invoice lines"
    (is (= {:lines '({:qty 1} {:qty 2})}
           (add-line {:lines '({:qty 2})} 1 "desc2")))))

(run-tests)
