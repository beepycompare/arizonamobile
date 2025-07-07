package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class GasStationBinding implements ViewBinding {
    public final AppCompatImageView gsCloseButton;
    public final ConstraintLayout gsFuelButton100;
    public final ConstraintLayout gsFuelButton92;
    public final ConstraintLayout gsFuelButton95;
    public final ConstraintLayout gsFuelButtonDiesel;
    public final ConstraintLayout gsFuelCountButton;
    public final TextView gsFuelCountButtonText;
    public final ConstraintLayout gsFuelCountContainer;
    public final AppCompatImageView gsFuelCountCurrencyIc;
    public final TextView gsFuelCountTitle;
    public final TextView gsFuelCounter;
    public final ConstraintLayout gsFuelCounterContainer;
    public final TextView gsFuelName100;
    public final TextView gsFuelName92;
    public final TextView gsFuelName95;
    public final TextView gsFuelNameDiesel;
    public final TextView gsFuelNowCount;
    public final TextView gsFuelNowTitle;
    public final ConstraintLayout gsFuelPicker;
    public final TextView gsFuelPickerTitle;
    public final SeekBar gsFuelSlider;
    public final TextView gsFuelSliderEnd;
    public final TextView gsFuelSliderStart;
    public final TextView gsFuelSliderTitle;
    public final TextView gsFuelTotalPrice;
    public final ConstraintLayout gsFuelType100;
    public final ConstraintLayout gsFuelType92;
    public final ConstraintLayout gsFuelType95;
    public final ConstraintLayout gsFuelTypeContainer100;
    public final ConstraintLayout gsFuelTypeContainer92;
    public final ConstraintLayout gsFuelTypeContainer95;
    public final ConstraintLayout gsFuelTypeContainerDiesel;
    public final ConstraintLayout gsFuelTypeDiesel;
    public final TextView gsFuelTypePrice100;
    public final TextView gsFuelTypePrice92;
    public final TextView gsFuelTypePrice95;
    public final TextView gsFuelTypePriceDiesel;
    public final ConstraintLayout gsLogoContainer;
    public final TextView gsLogoName;
    public final TextView gsLogoRed;
    public final TextView gsLogoWhite;
    public final ConstraintLayout gsNowContainer;
    public final ConstraintLayout gsShopContainer;
    public final RecyclerView gsShopList;
    public final TextView gsShopTitle;
    public final ConstraintLayout gsStation;
    public final ConstraintLayout gsTotalContainer;
    public final AppCompatImageView gsWater100;
    public final AppCompatImageView gsWater92;
    public final AppCompatImageView gsWater95;
    public final AppCompatImageView gsWaterDiesel;
    private final ConstraintLayout rootView;

    private GasStationBinding(ConstraintLayout rootView, AppCompatImageView gsCloseButton, ConstraintLayout gsFuelButton100, ConstraintLayout gsFuelButton92, ConstraintLayout gsFuelButton95, ConstraintLayout gsFuelButtonDiesel, ConstraintLayout gsFuelCountButton, TextView gsFuelCountButtonText, ConstraintLayout gsFuelCountContainer, AppCompatImageView gsFuelCountCurrencyIc, TextView gsFuelCountTitle, TextView gsFuelCounter, ConstraintLayout gsFuelCounterContainer, TextView gsFuelName100, TextView gsFuelName92, TextView gsFuelName95, TextView gsFuelNameDiesel, TextView gsFuelNowCount, TextView gsFuelNowTitle, ConstraintLayout gsFuelPicker, TextView gsFuelPickerTitle, SeekBar gsFuelSlider, TextView gsFuelSliderEnd, TextView gsFuelSliderStart, TextView gsFuelSliderTitle, TextView gsFuelTotalPrice, ConstraintLayout gsFuelType100, ConstraintLayout gsFuelType92, ConstraintLayout gsFuelType95, ConstraintLayout gsFuelTypeContainer100, ConstraintLayout gsFuelTypeContainer92, ConstraintLayout gsFuelTypeContainer95, ConstraintLayout gsFuelTypeContainerDiesel, ConstraintLayout gsFuelTypeDiesel, TextView gsFuelTypePrice100, TextView gsFuelTypePrice92, TextView gsFuelTypePrice95, TextView gsFuelTypePriceDiesel, ConstraintLayout gsLogoContainer, TextView gsLogoName, TextView gsLogoRed, TextView gsLogoWhite, ConstraintLayout gsNowContainer, ConstraintLayout gsShopContainer, RecyclerView gsShopList, TextView gsShopTitle, ConstraintLayout gsStation, ConstraintLayout gsTotalContainer, AppCompatImageView gsWater100, AppCompatImageView gsWater92, AppCompatImageView gsWater95, AppCompatImageView gsWaterDiesel) {
        this.rootView = rootView;
        this.gsCloseButton = gsCloseButton;
        this.gsFuelButton100 = gsFuelButton100;
        this.gsFuelButton92 = gsFuelButton92;
        this.gsFuelButton95 = gsFuelButton95;
        this.gsFuelButtonDiesel = gsFuelButtonDiesel;
        this.gsFuelCountButton = gsFuelCountButton;
        this.gsFuelCountButtonText = gsFuelCountButtonText;
        this.gsFuelCountContainer = gsFuelCountContainer;
        this.gsFuelCountCurrencyIc = gsFuelCountCurrencyIc;
        this.gsFuelCountTitle = gsFuelCountTitle;
        this.gsFuelCounter = gsFuelCounter;
        this.gsFuelCounterContainer = gsFuelCounterContainer;
        this.gsFuelName100 = gsFuelName100;
        this.gsFuelName92 = gsFuelName92;
        this.gsFuelName95 = gsFuelName95;
        this.gsFuelNameDiesel = gsFuelNameDiesel;
        this.gsFuelNowCount = gsFuelNowCount;
        this.gsFuelNowTitle = gsFuelNowTitle;
        this.gsFuelPicker = gsFuelPicker;
        this.gsFuelPickerTitle = gsFuelPickerTitle;
        this.gsFuelSlider = gsFuelSlider;
        this.gsFuelSliderEnd = gsFuelSliderEnd;
        this.gsFuelSliderStart = gsFuelSliderStart;
        this.gsFuelSliderTitle = gsFuelSliderTitle;
        this.gsFuelTotalPrice = gsFuelTotalPrice;
        this.gsFuelType100 = gsFuelType100;
        this.gsFuelType92 = gsFuelType92;
        this.gsFuelType95 = gsFuelType95;
        this.gsFuelTypeContainer100 = gsFuelTypeContainer100;
        this.gsFuelTypeContainer92 = gsFuelTypeContainer92;
        this.gsFuelTypeContainer95 = gsFuelTypeContainer95;
        this.gsFuelTypeContainerDiesel = gsFuelTypeContainerDiesel;
        this.gsFuelTypeDiesel = gsFuelTypeDiesel;
        this.gsFuelTypePrice100 = gsFuelTypePrice100;
        this.gsFuelTypePrice92 = gsFuelTypePrice92;
        this.gsFuelTypePrice95 = gsFuelTypePrice95;
        this.gsFuelTypePriceDiesel = gsFuelTypePriceDiesel;
        this.gsLogoContainer = gsLogoContainer;
        this.gsLogoName = gsLogoName;
        this.gsLogoRed = gsLogoRed;
        this.gsLogoWhite = gsLogoWhite;
        this.gsNowContainer = gsNowContainer;
        this.gsShopContainer = gsShopContainer;
        this.gsShopList = gsShopList;
        this.gsShopTitle = gsShopTitle;
        this.gsStation = gsStation;
        this.gsTotalContainer = gsTotalContainer;
        this.gsWater100 = gsWater100;
        this.gsWater92 = gsWater92;
        this.gsWater95 = gsWater95;
        this.gsWaterDiesel = gsWaterDiesel;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static GasStationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static GasStationBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.gas_station, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static GasStationBinding bind(View rootView) {
        int i = R.id.gs_close_button;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
        if (appCompatImageView != null) {
            i = R.id.gs_fuel_button_100;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
            if (constraintLayout != null) {
                i = R.id.gs_fuel_button_92;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                if (constraintLayout2 != null) {
                    i = R.id.gs_fuel_button_95;
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                    if (constraintLayout3 != null) {
                        i = R.id.gs_fuel_button_diesel;
                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                        if (constraintLayout4 != null) {
                            i = R.id.gs_fuel_count_button;
                            ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                            if (constraintLayout5 != null) {
                                i = R.id.gs_fuel_count_button_text;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView != null) {
                                    i = R.id.gs_fuel_count_container;
                                    ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (constraintLayout6 != null) {
                                        i = R.id.gs_fuel_count_currency_ic;
                                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                        if (appCompatImageView2 != null) {
                                            i = R.id.gs_fuel_count_title;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView2 != null) {
                                                i = R.id.gs_fuel_counter;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView3 != null) {
                                                    i = R.id.gs_fuel_counter_container;
                                                    ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                    if (constraintLayout7 != null) {
                                                        i = R.id.gs_fuel_name_100;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (textView4 != null) {
                                                            i = R.id.gs_fuel_name_92;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView5 != null) {
                                                                i = R.id.gs_fuel_name_95;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                if (textView6 != null) {
                                                                    i = R.id.gs_fuel_name_diesel;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (textView7 != null) {
                                                                        i = R.id.gs_fuel_now_count;
                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (textView8 != null) {
                                                                            i = R.id.gs_fuel_now_title;
                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (textView9 != null) {
                                                                                i = R.id.gs_fuel_picker;
                                                                                ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                if (constraintLayout8 != null) {
                                                                                    i = R.id.gs_fuel_picker_title;
                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (textView10 != null) {
                                                                                        i = R.id.gs_fuel_slider;
                                                                                        SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (seekBar != null) {
                                                                                            i = R.id.gs_fuel_slider_end;
                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (textView11 != null) {
                                                                                                i = R.id.gs_fuel_slider_start;
                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (textView12 != null) {
                                                                                                    i = R.id.gs_fuel_slider_title;
                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (textView13 != null) {
                                                                                                        i = R.id.gs_fuel_total_price;
                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                        if (textView14 != null) {
                                                                                                            i = R.id.gs_fuel_type_100;
                                                                                                            ConstraintLayout constraintLayout9 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                            if (constraintLayout9 != null) {
                                                                                                                i = R.id.gs_fuel_type_92;
                                                                                                                ConstraintLayout constraintLayout10 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                if (constraintLayout10 != null) {
                                                                                                                    i = R.id.gs_fuel_type_95;
                                                                                                                    ConstraintLayout constraintLayout11 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                    if (constraintLayout11 != null) {
                                                                                                                        i = R.id.gs_fuel_type_container_100;
                                                                                                                        ConstraintLayout constraintLayout12 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                        if (constraintLayout12 != null) {
                                                                                                                            i = R.id.gs_fuel_type_container_92;
                                                                                                                            ConstraintLayout constraintLayout13 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                            if (constraintLayout13 != null) {
                                                                                                                                i = R.id.gs_fuel_type_container_95;
                                                                                                                                ConstraintLayout constraintLayout14 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                if (constraintLayout14 != null) {
                                                                                                                                    i = R.id.gs_fuel_type_container_diesel;
                                                                                                                                    ConstraintLayout constraintLayout15 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                    if (constraintLayout15 != null) {
                                                                                                                                        i = R.id.gs_fuel_type_diesel;
                                                                                                                                        ConstraintLayout constraintLayout16 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                        if (constraintLayout16 != null) {
                                                                                                                                            i = R.id.gs_fuel_type_price_100;
                                                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                            if (textView15 != null) {
                                                                                                                                                i = R.id.gs_fuel_type_price_92;
                                                                                                                                                TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                if (textView16 != null) {
                                                                                                                                                    i = R.id.gs_fuel_type_price_95;
                                                                                                                                                    TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                    if (textView17 != null) {
                                                                                                                                                        i = R.id.gs_fuel_type_price_diesel;
                                                                                                                                                        TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                        if (textView18 != null) {
                                                                                                                                                            i = R.id.gs_logo_container;
                                                                                                                                                            ConstraintLayout constraintLayout17 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                            if (constraintLayout17 != null) {
                                                                                                                                                                i = R.id.gs_logo_name;
                                                                                                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                if (textView19 != null) {
                                                                                                                                                                    i = R.id.gs_logo_red;
                                                                                                                                                                    TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                    if (textView20 != null) {
                                                                                                                                                                        i = R.id.gs_logo_white;
                                                                                                                                                                        TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                        if (textView21 != null) {
                                                                                                                                                                            i = R.id.gs_now_container;
                                                                                                                                                                            ConstraintLayout constraintLayout18 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                            if (constraintLayout18 != null) {
                                                                                                                                                                                i = R.id.gs_shop_container;
                                                                                                                                                                                ConstraintLayout constraintLayout19 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                if (constraintLayout19 != null) {
                                                                                                                                                                                    i = R.id.gs_shop_list;
                                                                                                                                                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                    if (recyclerView != null) {
                                                                                                                                                                                        i = R.id.gs_shop_title;
                                                                                                                                                                                        TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                        if (textView22 != null) {
                                                                                                                                                                                            ConstraintLayout constraintLayout20 = (ConstraintLayout) rootView;
                                                                                                                                                                                            i = R.id.gs_total_container;
                                                                                                                                                                                            ConstraintLayout constraintLayout21 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                            if (constraintLayout21 != null) {
                                                                                                                                                                                                i = R.id.gs_water_100;
                                                                                                                                                                                                AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                if (appCompatImageView3 != null) {
                                                                                                                                                                                                    i = R.id.gs_water_92;
                                                                                                                                                                                                    AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                    if (appCompatImageView4 != null) {
                                                                                                                                                                                                        i = R.id.gs_water_95;
                                                                                                                                                                                                        AppCompatImageView appCompatImageView5 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                        if (appCompatImageView5 != null) {
                                                                                                                                                                                                            i = R.id.gs_water_diesel;
                                                                                                                                                                                                            AppCompatImageView appCompatImageView6 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                            if (appCompatImageView6 != null) {
                                                                                                                                                                                                                return new GasStationBinding(constraintLayout20, appCompatImageView, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, constraintLayout5, textView, constraintLayout6, appCompatImageView2, textView2, textView3, constraintLayout7, textView4, textView5, textView6, textView7, textView8, textView9, constraintLayout8, textView10, seekBar, textView11, textView12, textView13, textView14, constraintLayout9, constraintLayout10, constraintLayout11, constraintLayout12, constraintLayout13, constraintLayout14, constraintLayout15, constraintLayout16, textView15, textView16, textView17, textView18, constraintLayout17, textView19, textView20, textView21, constraintLayout18, constraintLayout19, recyclerView, textView22, constraintLayout20, constraintLayout21, appCompatImageView3, appCompatImageView4, appCompatImageView5, appCompatImageView6);
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
