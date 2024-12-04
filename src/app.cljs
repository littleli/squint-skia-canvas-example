(ns app
  (:require ["skia-canvas" :refer [Window]]))

(def win (Window. 300 300))

(defn- paint-job [e]
  (let [ctx (.getContext (.-target.canvas e) "2d")]
    (set! (.-lineWidth ctx) (+ 25 (* 25 (Math/cos (/ e.frame 10)))))
    (doto ctx
      (.beginPath)
      (.arc 150 150 50 0 (* 2 Math/PI))
      (.stroke)
      (.beginPath)
      (.arc 150 150 10 0 (* 2 Math/PI))
      (.stroke)
      (.fill))))

(doto win
  (.-title "Squint Canvas Window")
  (.on "draw" paint-job))
