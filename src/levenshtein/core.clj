(ns levenshtein.core)

(defn random-negative-int []
  (* -1 (Math/abs (.nextInt (java.util.Random.)))))

(defn same-chars-at?
  [s t i j]
  (if (= (.charAt s i) (.charAt t j)) 0 1))

(defn levenshtein-distance
  "Computes the levenshtein distance of two given strings."
  [s t]
  (loop [i (count s) j (count t)]
    (if (zero? (min i j))
      (max i j)
      (min ((inc (recur (dec i) j))
            (inc (recur i (dec j)))
            (+ (recur (dec i) (dec j)) (same-chars-at? s t i j)))))))
