(ns memefactory.styles.component.panels
  (:require [garden.def :refer [defstyles]]
            [garden.stylesheet :refer [at-media]]
            [clojure.string :as s]
            [memefactory.styles.base.icons :refer [icons]]
            [memefactory.styles.base.borders :refer [border-top border-bottom]]
            [memefactory.styles.base.colors :as c]
            [memefactory.styles.base.fonts :refer [font]]
            [memefactory.styles.base.media :refer [for-media-min for-media-max]]
            [garden.selectors :as sel]
            [garden.units :refer [pt px em rem]]
            [clojure.string :as str]))

(defn panel-with-icon [{:keys [url color]}]
  [:&
   {:background (c/color :meme-panel-bg)
    :box-shadow ".3em .3em 0px 0px rgba(0,0,0,0.05)"
    :border-radius "1em 1em 1em 1em"
    :position :relative}
   [:.icon
    (for-media-max :tablet
                   [:&
                    {:margin-right :auto
                     :margin-left :auto
                     :right 0
                     :left 0
                     :position :static}])
    {:display :block
     :background-size [(em 4) (em 4)]
     :background-repeat :no-repeat
     :box-shadow ".3em .3em 0px 0px rgba(0,0,0,0.05)"
     :border-radius "0em 0em 1em 1em"
     :margin-left (em 2)
     :margin-top (em 0)
     :position :absolute
     :height (em 4)
     :width (em 4)}]
   [:h2.title
    (font :bungee)
    (for-media-max :tablet
                   [:&
                    {:font-size (px 19)}])
    {:white-space :nowrap
     :position :relative
     ;; :color (c/color :section-caption)
     :font-size (px 25)
     :margin-top (em 0.3)
     :margin-bottom (em 0.1)
     :padding-top (em 0.5)
     :text-align :center}]
   [:h3.title
    {:white-space :nowrap
     :margin-top (em 0.1)
     :position :relative
     :color (c/color :section-subcaption)
     :font-size (px 15)
     :text-align :center}]
   [:.icon {:background-color (c/color color)
            :background-image (str "url('" url "')")}]
   [:h2.title {:color (c/color color)}]
   ])

(defn tabs []
  [:&
   {:display :flex
    :margin-right (em 6)
    :margin-left (em 6)
    :height (em 3)
    :line-height (em 3)
    :flex-wrap :wrap
    :justify-content :space-evenly}
   (for-media-max :tablet
                  [:&
                   {:margin-right (em 2)
                    :margin-left (em 2)}])
   [">div"
    (for-media-max :tablet
                   [:&
                    {:padding-right (em 0.2)
                     :padding-left (em 0.2)}])
    {:padding-right (em 1)}
    [:a
     {:color (c/color :section-subcaption)}]
    [:&.selected
     [:a
      (border-bottom {:color (c/color :pink)
                      :width (px 2)})]]]])
