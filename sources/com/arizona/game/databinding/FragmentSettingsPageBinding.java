package com.arizona.game.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizona.game.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
/* loaded from: classes3.dex */
public final class FragmentSettingsPageBinding implements ViewBinding {
    public final ImageView backIcon;
    public final LinearLayout backLayout;
    public final TextView backText;
    public final MaterialButton checkFilesButton;
    public final ImageView connectToServer;
    public final ConstraintLayout frameLayout;
    public final MaterialButton policyButton;
    public final ShapeableImageView projectLogo;
    public final MaterialButton reportButton;
    private final ConstraintLayout rootView;
    public final RecyclerView settingsRecycler;
    public final MaterialButton shareLogsButton;
    public final ImageView versionBackground;
    public final TextView versionText;

    private FragmentSettingsPageBinding(ConstraintLayout rootView, ImageView backIcon, LinearLayout backLayout, TextView backText, MaterialButton checkFilesButton, ImageView connectToServer, ConstraintLayout frameLayout, MaterialButton policyButton, ShapeableImageView projectLogo, MaterialButton reportButton, RecyclerView settingsRecycler, MaterialButton shareLogsButton, ImageView versionBackground, TextView versionText) {
        this.rootView = rootView;
        this.backIcon = backIcon;
        this.backLayout = backLayout;
        this.backText = backText;
        this.checkFilesButton = checkFilesButton;
        this.connectToServer = connectToServer;
        this.frameLayout = frameLayout;
        this.policyButton = policyButton;
        this.projectLogo = projectLogo;
        this.reportButton = reportButton;
        this.settingsRecycler = settingsRecycler;
        this.shareLogsButton = shareLogsButton;
        this.versionBackground = versionBackground;
        this.versionText = versionText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSettingsPageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentSettingsPageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_settings_page, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentSettingsPageBinding bind(View rootView) {
        int i = R.id.back_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.back_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                i = R.id.back_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.check_files_button;
                    MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(rootView, i);
                    if (materialButton != null) {
                        i = R.id.connect_to_server;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView2 != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                            i = R.id.policyButton;
                            MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(rootView, i);
                            if (materialButton2 != null) {
                                i = R.id.project_logo;
                                ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.findChildViewById(rootView, i);
                                if (shapeableImageView != null) {
                                    i = R.id.reportButton;
                                    MaterialButton materialButton3 = (MaterialButton) ViewBindings.findChildViewById(rootView, i);
                                    if (materialButton3 != null) {
                                        i = R.id.settings_recycler;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                        if (recyclerView != null) {
                                            i = R.id.shareLogsButton;
                                            MaterialButton materialButton4 = (MaterialButton) ViewBindings.findChildViewById(rootView, i);
                                            if (materialButton4 != null) {
                                                i = R.id.version_background;
                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                if (imageView3 != null) {
                                                    i = R.id.version_text;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView2 != null) {
                                                        return new FragmentSettingsPageBinding(constraintLayout, imageView, linearLayout, textView, materialButton, imageView2, constraintLayout, materialButton2, shapeableImageView, materialButton3, recyclerView, materialButton4, imageView3, textView2);
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
