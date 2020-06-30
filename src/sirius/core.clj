(ns sirius.core
  (:require [clojure.java.io :refer [resource]]
            [clojure.string :refer [split]])
  (:import [java.math BigInteger]
           [clojure.lang BigInt]))

(set! *warn-on-reflection* true)

(defn- parse-line
  [line]
  (let [pattern #"([0-9A-F]+);([^;]+);(?:[^;]*;){8}([^;]*);"
        [code name alt] (rest (re-find pattern line))]
    [(BigInteger. ^String code 16)
     (if (= (first name) \<) alt name)]))

(def name-table
  (let [db (slurp (resource "unicode_data.txt"))
        lines (split db #"\n")]
    (into {} (map parse-line) lines)))

(defprotocol UnicodeNameLookup
  (name-of [_]))

(extend-protocol UnicodeNameLookup
  (Class/forName "[B")
  (name-of [b] (-> ^bytes b BigInteger. name-table))

  Character
  (name-of [c] (name-table (int c)))

  String
  (name-of [s] (-> s first int name-table))

  BigInteger
  (name-of [bi] (-> ^BigInteger bi .longValue name-table))

  BigInt
  (name-of [bi] (-> ^BigInt bi .longValue name-table))

  Integer
  Long
  (name-of [i] (name-table i)))
