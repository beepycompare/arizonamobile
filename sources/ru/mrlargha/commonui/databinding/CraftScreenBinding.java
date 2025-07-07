package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class CraftScreenBinding implements ViewBinding {
    public final View bgRVCraft;
    public final AppCompatImageView btnBack;
    public final Button btnCancelCraft;
    public final Button btnDisableCreateItem;
    public final TextView btnEnableCreateItem;
    public final ProgressBar containerProgress;
    public final ItemInfoCostBinding costField;
    public final ConstraintLayout craftContainer;
    public final MaterialCardView cvColor;
    public final CardView cvColorIcon;
    public final EditText etResourcesCount;
    public final ItemInfoCostBinding experienceField;
    public final LinearLayout fieldLinear;
    public final Group groupCharacter;
    public final Guideline guideline;
    public final Guideline guidelineEnd;
    public final Guideline guidelineHor1;
    public final Guideline guidelineHor2;
    public final Guideline guidelineHor3;
    public final Guideline guidelineVer3;
    public final ImageView ivBgFlashLight;
    public final ImageView ivItemIcon;
    public final ImageButton ivMinus;
    public final ImageButton ivPlus;
    public final FrameLayout parentLayout;
    public final ProgressBar progressBar;
    private final FrameLayout rootView;
    public final RecyclerView rvColors;
    public final RecyclerView rvCraft;
    public final RecyclerView rvMenu;
    public final RecyclerView rvNeedResources;
    public final ItemInfoCostBinding successChanceField;
    public final LayoutCraftSuccessBinding successLayout;
    public final TextView tvColorName;
    public final TextView tvColorTitle;
    public final TextView tvItemDescription;
    public final TextView tvItemName;
    public final TextView tvResourcesTitle;
    public final TextView tvTitle;
    public final ImageView viewLine;
    public final View viewTopRight;

    private CraftScreenBinding(FrameLayout rootView, View bgRVCraft, AppCompatImageView btnBack, Button btnCancelCraft, Button btnDisableCreateItem, TextView btnEnableCreateItem, ProgressBar containerProgress, ItemInfoCostBinding costField, ConstraintLayout craftContainer, MaterialCardView cvColor, CardView cvColorIcon, EditText etResourcesCount, ItemInfoCostBinding experienceField, LinearLayout fieldLinear, Group groupCharacter, Guideline guideline, Guideline guidelineEnd, Guideline guidelineHor1, Guideline guidelineHor2, Guideline guidelineHor3, Guideline guidelineVer3, ImageView ivBgFlashLight, ImageView ivItemIcon, ImageButton ivMinus, ImageButton ivPlus, FrameLayout parentLayout, ProgressBar progressBar, RecyclerView rvColors, RecyclerView rvCraft, RecyclerView rvMenu, RecyclerView rvNeedResources, ItemInfoCostBinding successChanceField, LayoutCraftSuccessBinding successLayout, TextView tvColorName, TextView tvColorTitle, TextView tvItemDescription, TextView tvItemName, TextView tvResourcesTitle, TextView tvTitle, ImageView viewLine, View viewTopRight) {
        this.rootView = rootView;
        this.bgRVCraft = bgRVCraft;
        this.btnBack = btnBack;
        this.btnCancelCraft = btnCancelCraft;
        this.btnDisableCreateItem = btnDisableCreateItem;
        this.btnEnableCreateItem = btnEnableCreateItem;
        this.containerProgress = containerProgress;
        this.costField = costField;
        this.craftContainer = craftContainer;
        this.cvColor = cvColor;
        this.cvColorIcon = cvColorIcon;
        this.etResourcesCount = etResourcesCount;
        this.experienceField = experienceField;
        this.fieldLinear = fieldLinear;
        this.groupCharacter = groupCharacter;
        this.guideline = guideline;
        this.guidelineEnd = guidelineEnd;
        this.guidelineHor1 = guidelineHor1;
        this.guidelineHor2 = guidelineHor2;
        this.guidelineHor3 = guidelineHor3;
        this.guidelineVer3 = guidelineVer3;
        this.ivBgFlashLight = ivBgFlashLight;
        this.ivItemIcon = ivItemIcon;
        this.ivMinus = ivMinus;
        this.ivPlus = ivPlus;
        this.parentLayout = parentLayout;
        this.progressBar = progressBar;
        this.rvColors = rvColors;
        this.rvCraft = rvCraft;
        this.rvMenu = rvMenu;
        this.rvNeedResources = rvNeedResources;
        this.successChanceField = successChanceField;
        this.successLayout = successLayout;
        this.tvColorName = tvColorName;
        this.tvColorTitle = tvColorTitle;
        this.tvItemDescription = tvItemDescription;
        this.tvItemName = tvItemName;
        this.tvResourcesTitle = tvResourcesTitle;
        this.tvTitle = tvTitle;
        this.viewLine = viewLine;
        this.viewTopRight = viewTopRight;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static CraftScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CraftScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.craft_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static CraftScreenBinding bind(View rootView) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        View findChildViewById4;
        int i = R.id.bgRVCraft;
        View findChildViewById5 = ViewBindings.findChildViewById(rootView, i);
        if (findChildViewById5 != null) {
            i = R.id.btnBack;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
            if (appCompatImageView != null) {
                i = R.id.btnCancelCraft;
                Button button = (Button) ViewBindings.findChildViewById(rootView, i);
                if (button != null) {
                    i = R.id.btnDisableCreateItem;
                    Button button2 = (Button) ViewBindings.findChildViewById(rootView, i);
                    if (button2 != null) {
                        i = R.id.btnEnableCreateItem;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView != null) {
                            i = R.id.container_progress;
                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                            if (progressBar != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.costField))) != null) {
                                ItemInfoCostBinding bind = ItemInfoCostBinding.bind(findChildViewById);
                                i = R.id.craft_container;
                                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                if (constraintLayout != null) {
                                    i = R.id.cvColor;
                                    MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(rootView, i);
                                    if (materialCardView != null) {
                                        i = R.id.cvColorIcon;
                                        CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, i);
                                        if (cardView != null) {
                                            i = R.id.etResourcesCount;
                                            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, i);
                                            if (editText != null && (findChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.experienceField))) != null) {
                                                ItemInfoCostBinding bind2 = ItemInfoCostBinding.bind(findChildViewById2);
                                                i = R.id.fieldLinear;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                if (linearLayout != null) {
                                                    i = R.id.groupCharacter;
                                                    Group group = (Group) ViewBindings.findChildViewById(rootView, i);
                                                    if (group != null) {
                                                        i = R.id.guideline;
                                                        Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                        if (guideline != null) {
                                                            i = R.id.guidelineEnd;
                                                            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                            if (guideline2 != null) {
                                                                i = R.id.guidelineHor1;
                                                                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                if (guideline3 != null) {
                                                                    i = R.id.guidelineHor2;
                                                                    Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                    if (guideline4 != null) {
                                                                        i = R.id.guidelineHor3;
                                                                        Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                        if (guideline5 != null) {
                                                                            i = R.id.guidelineVer3;
                                                                            Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                            if (guideline6 != null) {
                                                                                i = R.id.ivBgFlashLight;
                                                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                if (imageView != null) {
                                                                                    i = R.id.ivItemIcon;
                                                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (imageView2 != null) {
                                                                                        i = R.id.ivMinus;
                                                                                        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (imageButton != null) {
                                                                                            i = R.id.ivPlus;
                                                                                            ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (imageButton2 != null) {
                                                                                                FrameLayout frameLayout = (FrameLayout) rootView;
                                                                                                i = R.id.progressBar;
                                                                                                ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (progressBar2 != null) {
                                                                                                    i = R.id.rvColors;
                                                                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (recyclerView != null) {
                                                                                                        i = R.id.rvCraft;
                                                                                                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                                                        if (recyclerView2 != null) {
                                                                                                            i = R.id.rvMenu;
                                                                                                            RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                                                            if (recyclerView3 != null) {
                                                                                                                i = R.id.rvNeedResources;
                                                                                                                RecyclerView recyclerView4 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                if (recyclerView4 != null && (findChildViewById3 = ViewBindings.findChildViewById(rootView, (i = R.id.successChanceField))) != null) {
                                                                                                                    ItemInfoCostBinding bind3 = ItemInfoCostBinding.bind(findChildViewById3);
                                                                                                                    i = R.id.successLayout;
                                                                                                                    View findChildViewById6 = ViewBindings.findChildViewById(rootView, i);
                                                                                                                    if (findChildViewById6 != null) {
                                                                                                                        LayoutCraftSuccessBinding bind4 = LayoutCraftSuccessBinding.bind(findChildViewById6);
                                                                                                                        i = R.id.tvColorName;
                                                                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                        if (textView2 != null) {
                                                                                                                            i = R.id.tvColorTitle;
                                                                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                            if (textView3 != null) {
                                                                                                                                i = R.id.tvItemDescription;
                                                                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                if (textView4 != null) {
                                                                                                                                    i = R.id.tvItemName;
                                                                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                    if (textView5 != null) {
                                                                                                                                        i = R.id.tvResourcesTitle;
                                                                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                        if (textView6 != null) {
                                                                                                                                            i = R.id.tvTitle;
                                                                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                            if (textView7 != null) {
                                                                                                                                                i = R.id.viewLine;
                                                                                                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                if (imageView3 != null && (findChildViewById4 = ViewBindings.findChildViewById(rootView, (i = R.id.viewTopRight))) != null) {
                                                                                                                                                    return new CraftScreenBinding(frameLayout, findChildViewById5, appCompatImageView, button, button2, textView, progressBar, bind, constraintLayout, materialCardView, cardView, editText, bind2, linearLayout, group, guideline, guideline2, guideline3, guideline4, guideline5, guideline6, imageView, imageView2, imageButton, imageButton2, frameLayout, progressBar2, recyclerView, recyclerView2, recyclerView3, recyclerView4, bind3, bind4, textView2, textView3, textView4, textView5, textView6, textView7, imageView3, findChildViewById4);
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
