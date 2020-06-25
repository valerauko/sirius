(ns sirius.core-test
  (:require [clojure.test :refer :all]
            [sirius.core :refer :all]))

(deftest name-of-test
  (let [name "LIBRA"]
    (testing "Using bytes"
      (let [byte-arr (.toByteArray (BigInteger. "264E" 16))]
        (is (= (name-of byte-arr) name))))
    (testing "Using char"
      (is (= (name-of \♎) name)))
    (testing "Using string"
      (is (= (name-of "♎") name)))
    (testing "Using number"
      (is (= (name-of 9806) name)))))
