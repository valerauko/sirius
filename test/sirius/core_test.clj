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
    (testing "Using integer (long)"
      (is (= (name-of 9806) name)))
    (testing "Using BigInteger"
      (is (= (name-of (BigInteger. "264E" 16)) name)))))

(deftest control-char-test
  (testing "<control> characters get names too"
    (is (= (name-of 0) "NULL"))))
