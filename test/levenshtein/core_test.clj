(ns levenshtein.core-test
  (:require [clojure.test :refer :all]
            [levenshtein.core :refer :all]))

(testing "Levenshtein distance"
  (is (= (levenshtein-distance "single" "radi")
         (levenshtein-distance "radi" "single")) "is symmetric")
  (testing "with two equal strings"
    (is (= 0 (levenshtein-distance "single" "single")) "is reflexive"))
  (testing "with strings of unequal length"
    (is (>= 4 (levenshtein-distance "radi", "ub")))
    (is (<= 0 (levenshtein-distance "single", "fuetzgue"))
      "is positive definite")))
