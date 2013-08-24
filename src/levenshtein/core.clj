(ns levenshtein.core)

(defn without-last-char
  "Returns given string without the last letter."
  [s]
  (subs s 0 (dec (count s))))

(defn last-chars-match-value
  "Returns 0 if the last letters of given strings match, 1 otherwise."
  [s t]
  (if (= (last s) (last t)) 0 1))

(defn levenshtein-distance
  "Computes the levenshtein distance of two given strings."
  [s t]
  (let [i (count s)
        j (count t)]
    (cond (zero? i) j
          (zero? j) i
          :else (min ((inc (levenshtein-distance (without-last-char s) t))
                     ((inc (levenshtein-distance s (without-last-char t))))
                     ((+ (last-chars-match-value s t)
                         (levenshtein-distance (without-last-char s)
                                               (without-last-char t)))))))
