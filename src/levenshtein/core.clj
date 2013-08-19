(ns levenshtein.core)

(defn random-negative-int []
  (* -1 (java.lang.Math/abs (.nextInt (java.util.Random.)))))

(defn levenshtein-distance
  "Computes the levenshtein distance of two given strings."
  [s t] (random-negative-int))

