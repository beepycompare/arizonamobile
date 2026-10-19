package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class SettingsLayoutBinding implements ViewBinding {
    public final ImageView backButton;
    public final ConstraintLayout controlPageButton;
    public final ImageView controlPageButtonIc;
    public final TextView controlPageButtonTxt;
    public final ConstraintLayout exitPageButton;
    public final ImageView exitPageButtonIc;
    public final TextView exitPageButtonTxt;
    public final ConstraintLayout graphicPageButton;
    public final ImageView graphicPageButtonIc;
    public final TextView graphicPageButtonTxt;
    public final Guideline leftBackButtonLine;
    public final ConstraintLayout mainPageButton;
    public final ImageView mainPageButtonIc;
    public final TextView mainPageButtonTxt;
    public final ConstraintLayout mainSettingsPage;
    public final Guideline menuLeftLine;
    public final Guideline menuTopLine;
    public final TextView pageName;
    public final Guideline rcLeftLine;
    public final LinearLayout resetSettingsButton;
    private final ConstraintLayout rootView;
    public final ImageView saveButton;
    public final Guideline settingsButtonLeftLine;
    public final ConstraintLayout settingsLayout;
    public final RecyclerView settingsRc;
    public final ConstraintLayout soundPageButton;
    public final ImageView soundPageButtonIc;
    public final TextView soundPageButtonTxt;
    public final Guideline topBackButtonLine;

    private SettingsLayoutBinding(ConstraintLayout rootView, ImageView backButton, ConstraintLayout controlPageButton, ImageView controlPageButtonIc, TextView controlPageButtonTxt, ConstraintLayout exitPageButton, ImageView exitPageButtonIc, TextView exitPageButtonTxt, ConstraintLayout graphicPageButton, ImageView graphicPageButtonIc, TextView graphicPageButtonTxt, Guideline leftBackButtonLine, ConstraintLayout mainPageButton, ImageView mainPageButtonIc, TextView mainPageButtonTxt, ConstraintLayout mainSettingsPage, Guideline menuLeftLine, Guideline menuTopLine, TextView pageName, Guideline rcLeftLine, LinearLayout resetSettingsButton, ImageView saveButton, Guideline settingsButtonLeftLine, ConstraintLayout settingsLayout, RecyclerView settingsRc, ConstraintLayout soundPageButton, ImageView soundPageButtonIc, TextView soundPageButtonTxt, Guideline topBackButtonLine) {
        this.rootView = rootView;
        this.backButton = backButton;
        this.controlPageButton = controlPageButton;
        this.controlPageButtonIc = controlPageButtonIc;
        this.controlPageButtonTxt = controlPageButtonTxt;
        this.exitPageButton = exitPageButton;
        this.exitPageButtonIc = exitPageButtonIc;
        this.exitPageButtonTxt = exitPageButtonTxt;
        this.graphicPageButton = graphicPageButton;
        this.graphicPageButtonIc = graphicPageButtonIc;
        this.graphicPageButtonTxt = graphicPageButtonTxt;
        this.leftBackButtonLine = leftBackButtonLine;
        this.mainPageButton = mainPageButton;
        this.mainPageButtonIc = mainPageButtonIc;
        this.mainPageButtonTxt = mainPageButtonTxt;
        this.mainSettingsPage = mainSettingsPage;
        this.menuLeftLine = menuLeftLine;
        this.menuTopLine = menuTopLine;
        this.pageName = pageName;
        this.rcLeftLine = rcLeftLine;
        this.resetSettingsButton = resetSettingsButton;
        this.saveButton = saveButton;
        this.settingsButtonLeftLine = settingsButtonLeftLine;
        this.settingsLayout = settingsLayout;
        this.settingsRc = settingsRc;
        this.soundPageButton = soundPageButton;
        this.soundPageButtonIc = soundPageButtonIc;
        this.soundPageButtonTxt = soundPageButtonTxt;
        this.topBackButtonLine = topBackButtonLine;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SettingsLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SettingsLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.settings_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static SettingsLayoutBinding bind(View rootView) {
        int i = R.id.back_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.control_page_button;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
            if (constraintLayout != null) {
                i = R.id.control_page_button_ic;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView2 != null) {
                    i = R.id.control_page_button_txt;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView != null) {
                        i = R.id.exit_page_button;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                        if (constraintLayout2 != null) {
                            i = R.id.exit_page_button_ic;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                            if (imageView3 != null) {
                                i = R.id.exit_page_button_txt;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView2 != null) {
                                    i = R.id.graphic_page_button;
                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (constraintLayout3 != null) {
                                        i = R.id.graphic_page_button_ic;
                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                        if (imageView4 != null) {
                                            i = R.id.graphic_page_button_txt;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView3 != null) {
                                                i = R.id.left_back_button_line;
                                                Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                if (guideline != null) {
                                                    i = R.id.main_page_button;
                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                    if (constraintLayout4 != null) {
                                                        i = R.id.main_page_button_ic;
                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                        if (imageView5 != null) {
                                                            i = R.id.main_page_button_txt;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView4 != null) {
                                                                i = R.id.main_settings_page;
                                                                ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                if (constraintLayout5 != null) {
                                                                    i = R.id.menu_left_line;
                                                                    Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                    if (guideline2 != null) {
                                                                        i = R.id.menu_top_line;
                                                                        Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                        if (guideline3 != null) {
                                                                            i = R.id.page_name;
                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (textView5 != null) {
                                                                                i = R.id.rc_left_line;
                                                                                Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                if (guideline4 != null) {
                                                                                    i = R.id.reset_settings_button;
                                                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (linearLayout != null) {
                                                                                        i = R.id.save_button;
                                                                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (imageView6 != null) {
                                                                                            i = R.id.settings_button_left_line;
                                                                                            Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (guideline5 != null) {
                                                                                                ConstraintLayout constraintLayout6 = (ConstraintLayout) rootView;
                                                                                                i = R.id.settings_rc;
                                                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (recyclerView != null) {
                                                                                                    i = R.id.sound_page_button;
                                                                                                    ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (constraintLayout7 != null) {
                                                                                                        i = R.id.sound_page_button_ic;
                                                                                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                        if (imageView7 != null) {
                                                                                                            i = R.id.sound_page_button_txt;
                                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                            if (textView6 != null) {
                                                                                                                i = R.id.top_back_button_line;
                                                                                                                Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                if (guideline6 != null) {
                                                                                                                    return new SettingsLayoutBinding(constraintLayout6, imageView, constraintLayout, imageView2, textView, constraintLayout2, imageView3, textView2, constraintLayout3, imageView4, textView3, guideline, constraintLayout4, imageView5, textView4, constraintLayout5, guideline2, guideline3, textView5, guideline4, linearLayout, imageView6, guideline5, constraintLayout6, recyclerView, constraintLayout7, imageView7, textView6, guideline6);
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
