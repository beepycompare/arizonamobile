package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class AzStreetFoodScreenBinding implements ViewBinding {
    public final ConstraintLayout armourContainer;
    public final TextView armourCounter;
    public final AppCompatImageView backButton;
    public final AppCompatImageView firstBuyButton;
    public final ConstraintLayout firstChoiceFood;
    public final ConstraintLayout healthContainer;
    public final TextView healthCounter;
    public final AppCompatImageView hotdogImage;
    public final ConstraintLayout hotdogImageContainer;
    public final AppCompatImageView hotdogName;
    public final TextView hotdogPrice;
    public final ConstraintLayout hotdogPriceContainer;
    public final ConstraintLayout hungryContainer;
    public final TextView hungryCounter;
    public final Guideline leftChoiceLine;
    public final Guideline leftPizzaBoyLine;
    public final AppCompatImageView pizzaBoy;
    public final AppCompatImageView pizzaImage;
    public final ConstraintLayout pizzaImageContainer;
    public final AppCompatImageView pizzaName;
    public final TextView pizzaPrice;
    public final ConstraintLayout pizzaPriceContainer;
    public final Guideline rightChoiceLine;
    private final ConstraintLayout rootView;
    public final AppCompatImageView secondBuyButton;
    public final ConstraintLayout secondChoiceFood;
    public final ConstraintLayout selectFoodContainer;
    public final ConstraintLayout streetFood;
    public final AppCompatImageView streetFoodArmour;
    public final ProgressBar streetFoodArmourProgressBar;
    public final AppCompatImageView streetFoodHeart;
    public final ProgressBar streetFoodHeartProgressBar;
    public final AppCompatImageView streetFoodHungry;
    public final ProgressBar streetFoodHungryProgressBar;
    public final AppCompatImageView streetFoodLogo;
    public final Guideline topLine;
    public final ConstraintLayout userInfoContainer;
    public final Guideline userInfoStartLine;

    private AzStreetFoodScreenBinding(ConstraintLayout rootView, ConstraintLayout armourContainer, TextView armourCounter, AppCompatImageView backButton, AppCompatImageView firstBuyButton, ConstraintLayout firstChoiceFood, ConstraintLayout healthContainer, TextView healthCounter, AppCompatImageView hotdogImage, ConstraintLayout hotdogImageContainer, AppCompatImageView hotdogName, TextView hotdogPrice, ConstraintLayout hotdogPriceContainer, ConstraintLayout hungryContainer, TextView hungryCounter, Guideline leftChoiceLine, Guideline leftPizzaBoyLine, AppCompatImageView pizzaBoy, AppCompatImageView pizzaImage, ConstraintLayout pizzaImageContainer, AppCompatImageView pizzaName, TextView pizzaPrice, ConstraintLayout pizzaPriceContainer, Guideline rightChoiceLine, AppCompatImageView secondBuyButton, ConstraintLayout secondChoiceFood, ConstraintLayout selectFoodContainer, ConstraintLayout streetFood, AppCompatImageView streetFoodArmour, ProgressBar streetFoodArmourProgressBar, AppCompatImageView streetFoodHeart, ProgressBar streetFoodHeartProgressBar, AppCompatImageView streetFoodHungry, ProgressBar streetFoodHungryProgressBar, AppCompatImageView streetFoodLogo, Guideline topLine, ConstraintLayout userInfoContainer, Guideline userInfoStartLine) {
        this.rootView = rootView;
        this.armourContainer = armourContainer;
        this.armourCounter = armourCounter;
        this.backButton = backButton;
        this.firstBuyButton = firstBuyButton;
        this.firstChoiceFood = firstChoiceFood;
        this.healthContainer = healthContainer;
        this.healthCounter = healthCounter;
        this.hotdogImage = hotdogImage;
        this.hotdogImageContainer = hotdogImageContainer;
        this.hotdogName = hotdogName;
        this.hotdogPrice = hotdogPrice;
        this.hotdogPriceContainer = hotdogPriceContainer;
        this.hungryContainer = hungryContainer;
        this.hungryCounter = hungryCounter;
        this.leftChoiceLine = leftChoiceLine;
        this.leftPizzaBoyLine = leftPizzaBoyLine;
        this.pizzaBoy = pizzaBoy;
        this.pizzaImage = pizzaImage;
        this.pizzaImageContainer = pizzaImageContainer;
        this.pizzaName = pizzaName;
        this.pizzaPrice = pizzaPrice;
        this.pizzaPriceContainer = pizzaPriceContainer;
        this.rightChoiceLine = rightChoiceLine;
        this.secondBuyButton = secondBuyButton;
        this.secondChoiceFood = secondChoiceFood;
        this.selectFoodContainer = selectFoodContainer;
        this.streetFood = streetFood;
        this.streetFoodArmour = streetFoodArmour;
        this.streetFoodArmourProgressBar = streetFoodArmourProgressBar;
        this.streetFoodHeart = streetFoodHeart;
        this.streetFoodHeartProgressBar = streetFoodHeartProgressBar;
        this.streetFoodHungry = streetFoodHungry;
        this.streetFoodHungryProgressBar = streetFoodHungryProgressBar;
        this.streetFoodLogo = streetFoodLogo;
        this.topLine = topLine;
        this.userInfoContainer = userInfoContainer;
        this.userInfoStartLine = userInfoStartLine;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AzStreetFoodScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AzStreetFoodScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.az_street_food_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static AzStreetFoodScreenBinding bind(View rootView) {
        int i = R.id.armour_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
        if (constraintLayout != null) {
            i = R.id.armour_counter;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.back_button;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                if (appCompatImageView != null) {
                    i = R.id.first_buy_button;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                    if (appCompatImageView2 != null) {
                        i = R.id.first_choice_food;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                        if (constraintLayout2 != null) {
                            i = R.id.health_container;
                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                            if (constraintLayout3 != null) {
                                i = R.id.health_counter;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView2 != null) {
                                    i = R.id.hotdog_image;
                                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                    if (appCompatImageView3 != null) {
                                        i = R.id.hotdog_image_container;
                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (constraintLayout4 != null) {
                                            i = R.id.hotdog_name;
                                            AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                            if (appCompatImageView4 != null) {
                                                i = R.id.hotdog_price;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView3 != null) {
                                                    i = R.id.hotdog_price_container;
                                                    ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                    if (constraintLayout5 != null) {
                                                        i = R.id.hungry_container;
                                                        ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                        if (constraintLayout6 != null) {
                                                            i = R.id.hungry_counter;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView4 != null) {
                                                                i = R.id.left_choice_line;
                                                                Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                if (guideline != null) {
                                                                    i = R.id.left_pizza_boy_line;
                                                                    Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                    if (guideline2 != null) {
                                                                        i = R.id.pizza_boy;
                                                                        AppCompatImageView appCompatImageView5 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (appCompatImageView5 != null) {
                                                                            i = R.id.pizza_image;
                                                                            AppCompatImageView appCompatImageView6 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (appCompatImageView6 != null) {
                                                                                i = R.id.pizza_image_container;
                                                                                ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                if (constraintLayout7 != null) {
                                                                                    i = R.id.pizza_name;
                                                                                    AppCompatImageView appCompatImageView7 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (appCompatImageView7 != null) {
                                                                                        i = R.id.pizza_price;
                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (textView5 != null) {
                                                                                            i = R.id.pizza_price_container;
                                                                                            ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (constraintLayout8 != null) {
                                                                                                i = R.id.right_choice_line;
                                                                                                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (guideline3 != null) {
                                                                                                    i = R.id.second_buy_button;
                                                                                                    AppCompatImageView appCompatImageView8 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (appCompatImageView8 != null) {
                                                                                                        i = R.id.second_choice_food;
                                                                                                        ConstraintLayout constraintLayout9 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                        if (constraintLayout9 != null) {
                                                                                                            i = R.id.select_food_container;
                                                                                                            ConstraintLayout constraintLayout10 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                            if (constraintLayout10 != null) {
                                                                                                                ConstraintLayout constraintLayout11 = (ConstraintLayout) rootView;
                                                                                                                i = R.id.street_food_armour;
                                                                                                                AppCompatImageView appCompatImageView9 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                if (appCompatImageView9 != null) {
                                                                                                                    i = R.id.street_food_armour_progress_bar;
                                                                                                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                                                                                                                    if (progressBar != null) {
                                                                                                                        i = R.id.street_food_heart;
                                                                                                                        AppCompatImageView appCompatImageView10 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                        if (appCompatImageView10 != null) {
                                                                                                                            i = R.id.street_food_heart_progress_bar;
                                                                                                                            ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                                                                                                                            if (progressBar2 != null) {
                                                                                                                                i = R.id.street_food_hungry;
                                                                                                                                AppCompatImageView appCompatImageView11 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                if (appCompatImageView11 != null) {
                                                                                                                                    i = R.id.street_food_hungry_progress_bar;
                                                                                                                                    ProgressBar progressBar3 = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                    if (progressBar3 != null) {
                                                                                                                                        i = R.id.street_food_logo;
                                                                                                                                        AppCompatImageView appCompatImageView12 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                        if (appCompatImageView12 != null) {
                                                                                                                                            i = R.id.top_line;
                                                                                                                                            Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                            if (guideline4 != null) {
                                                                                                                                                i = R.id.user_info_container;
                                                                                                                                                ConstraintLayout constraintLayout12 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                if (constraintLayout12 != null) {
                                                                                                                                                    i = R.id.user_info_start_line;
                                                                                                                                                    Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                    if (guideline5 != null) {
                                                                                                                                                        return new AzStreetFoodScreenBinding(constraintLayout11, constraintLayout, textView, appCompatImageView, appCompatImageView2, constraintLayout2, constraintLayout3, textView2, appCompatImageView3, constraintLayout4, appCompatImageView4, textView3, constraintLayout5, constraintLayout6, textView4, guideline, guideline2, appCompatImageView5, appCompatImageView6, constraintLayout7, appCompatImageView7, textView5, constraintLayout8, guideline3, appCompatImageView8, constraintLayout9, constraintLayout10, constraintLayout11, appCompatImageView9, progressBar, appCompatImageView10, progressBar2, appCompatImageView11, progressBar3, appCompatImageView12, guideline4, constraintLayout12, guideline5);
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
