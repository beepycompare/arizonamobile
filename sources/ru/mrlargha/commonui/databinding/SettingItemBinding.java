package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.slider.Slider;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class SettingItemBinding implements ViewBinding {
    public final TextView linkTextSetting;
    public final LinearLayout linkTextSettingContainer;
    private final LinearLayout rootView;
    public final LinearLayout selectorSettingGroup;
    public final LinearLayout settingItem;
    public final TextView settingName;
    public final RelativeLayout settingSelector1;
    public final RelativeLayout settingSelector15;
    public final TextView settingSelector15Txt;
    public final TextView settingSelector1Txt;
    public final RelativeLayout settingSelector25;
    public final TextView settingSelector25Txt;
    public final RelativeLayout settingSelector30;
    public final TextView settingSelector30Txt;
    public final Slider sliderSetting;
    public final LinearLayout sliderSettingContainer;
    public final TextView sliderSettingText;
    public final SwitchCompat switchSetting;
    public final TextView switchTextSetting;
    public final ImageView switchTextSettingBack;
    public final LinearLayout switchTextSettingContainer;
    public final ImageView switchTextSettingForward;

    private SettingItemBinding(LinearLayout rootView, TextView linkTextSetting, LinearLayout linkTextSettingContainer, LinearLayout selectorSettingGroup, LinearLayout settingItem, TextView settingName, RelativeLayout settingSelector1, RelativeLayout settingSelector15, TextView settingSelector15Txt, TextView settingSelector1Txt, RelativeLayout settingSelector25, TextView settingSelector25Txt, RelativeLayout settingSelector30, TextView settingSelector30Txt, Slider sliderSetting, LinearLayout sliderSettingContainer, TextView sliderSettingText, SwitchCompat switchSetting, TextView switchTextSetting, ImageView switchTextSettingBack, LinearLayout switchTextSettingContainer, ImageView switchTextSettingForward) {
        this.rootView = rootView;
        this.linkTextSetting = linkTextSetting;
        this.linkTextSettingContainer = linkTextSettingContainer;
        this.selectorSettingGroup = selectorSettingGroup;
        this.settingItem = settingItem;
        this.settingName = settingName;
        this.settingSelector1 = settingSelector1;
        this.settingSelector15 = settingSelector15;
        this.settingSelector15Txt = settingSelector15Txt;
        this.settingSelector1Txt = settingSelector1Txt;
        this.settingSelector25 = settingSelector25;
        this.settingSelector25Txt = settingSelector25Txt;
        this.settingSelector30 = settingSelector30;
        this.settingSelector30Txt = settingSelector30Txt;
        this.sliderSetting = sliderSetting;
        this.sliderSettingContainer = sliderSettingContainer;
        this.sliderSettingText = sliderSettingText;
        this.switchSetting = switchSetting;
        this.switchTextSetting = switchTextSetting;
        this.switchTextSettingBack = switchTextSettingBack;
        this.switchTextSettingContainer = switchTextSettingContainer;
        this.switchTextSettingForward = switchTextSettingForward;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SettingItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SettingItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.setting_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static SettingItemBinding bind(View rootView) {
        int i = R.id.link_text_setting;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.link_text_setting_container;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                i = R.id.selector_setting_group;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                if (linearLayout2 != null) {
                    LinearLayout linearLayout3 = (LinearLayout) rootView;
                    i = R.id.setting_name;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.setting_selector_1;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                        if (relativeLayout != null) {
                            i = R.id.setting_selector_15;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                            if (relativeLayout2 != null) {
                                i = R.id.setting_selector_15_txt;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView3 != null) {
                                    i = R.id.setting_selector_1_txt;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView4 != null) {
                                        i = R.id.setting_selector_25;
                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (relativeLayout3 != null) {
                                            i = R.id.setting_selector_25_txt;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView5 != null) {
                                                i = R.id.setting_selector_30;
                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                                if (relativeLayout4 != null) {
                                                    i = R.id.setting_selector_30_txt;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView6 != null) {
                                                        i = R.id.slider_setting;
                                                        Slider slider = (Slider) ViewBindings.findChildViewById(rootView, i);
                                                        if (slider != null) {
                                                            i = R.id.slider_setting_container;
                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                            if (linearLayout4 != null) {
                                                                i = R.id.slider_setting_text;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                if (textView7 != null) {
                                                                    i = R.id.switch_setting;
                                                                    SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(rootView, i);
                                                                    if (switchCompat != null) {
                                                                        i = R.id.switch_text_setting;
                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (textView8 != null) {
                                                                            i = R.id.switch_text_setting_back;
                                                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (imageView != null) {
                                                                                i = R.id.switch_text_setting_container;
                                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                if (linearLayout5 != null) {
                                                                                    i = R.id.switch_text_setting_forward;
                                                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (imageView2 != null) {
                                                                                        return new SettingItemBinding(linearLayout3, textView, linearLayout, linearLayout2, linearLayout3, textView2, relativeLayout, relativeLayout2, textView3, textView4, relativeLayout3, textView5, relativeLayout4, textView6, slider, linearLayout4, textView7, switchCompat, textView8, imageView, linearLayout5, imageView2);
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
