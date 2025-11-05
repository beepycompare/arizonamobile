package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class CaseRouletteBinding implements ViewBinding {
    public final ImageView caseGlassIc;
    public final ImageView caseIc;
    public final TextView caseName;
    public final ConstraintLayout casePage;
    public final ConstraintLayout caseRoulette;
    public final RecyclerView caseRouletteRc;
    public final CardView caseRouletteStick;
    public final CardView exitButton;
    public final CardView getPrizeButton;
    public final ImageView getPrizeGlass;
    public final ConstraintLayout instantOpenContainer;
    public final ImageView instantOpenContainerIc;
    public final ImageView itemRarityGlow;
    public final ConstraintLayout openCaseButton;
    public final RecyclerView possibleAwardsRc;
    public final ConstraintLayout prizeContainer;
    public final ImageView prizeIc;
    public final TextView prizeJoke;
    public final TextView prizeName;
    public final ConstraintLayout prizePage;
    public final CardView prizeRarityStick;
    private final ConstraintLayout rootView;
    public final TextView secretPrizeText;
    public final TextView tvInstantOpen;

    private CaseRouletteBinding(ConstraintLayout rootView, ImageView caseGlassIc, ImageView caseIc, TextView caseName, ConstraintLayout casePage, ConstraintLayout caseRoulette, RecyclerView caseRouletteRc, CardView caseRouletteStick, CardView exitButton, CardView getPrizeButton, ImageView getPrizeGlass, ConstraintLayout instantOpenContainer, ImageView instantOpenContainerIc, ImageView itemRarityGlow, ConstraintLayout openCaseButton, RecyclerView possibleAwardsRc, ConstraintLayout prizeContainer, ImageView prizeIc, TextView prizeJoke, TextView prizeName, ConstraintLayout prizePage, CardView prizeRarityStick, TextView secretPrizeText, TextView tvInstantOpen) {
        this.rootView = rootView;
        this.caseGlassIc = caseGlassIc;
        this.caseIc = caseIc;
        this.caseName = caseName;
        this.casePage = casePage;
        this.caseRoulette = caseRoulette;
        this.caseRouletteRc = caseRouletteRc;
        this.caseRouletteStick = caseRouletteStick;
        this.exitButton = exitButton;
        this.getPrizeButton = getPrizeButton;
        this.getPrizeGlass = getPrizeGlass;
        this.instantOpenContainer = instantOpenContainer;
        this.instantOpenContainerIc = instantOpenContainerIc;
        this.itemRarityGlow = itemRarityGlow;
        this.openCaseButton = openCaseButton;
        this.possibleAwardsRc = possibleAwardsRc;
        this.prizeContainer = prizeContainer;
        this.prizeIc = prizeIc;
        this.prizeJoke = prizeJoke;
        this.prizeName = prizeName;
        this.prizePage = prizePage;
        this.prizeRarityStick = prizeRarityStick;
        this.secretPrizeText = secretPrizeText;
        this.tvInstantOpen = tvInstantOpen;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static CaseRouletteBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CaseRouletteBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.case_roulette, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static CaseRouletteBinding bind(View rootView) {
        int i = R.id.case_glass_ic;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.case_ic;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView2 != null) {
                i = R.id.case_name;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.case_page;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                    if (constraintLayout != null) {
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) rootView;
                        i = R.id.case_roulette_rc;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                        if (recyclerView != null) {
                            i = R.id.case_roulette_stick;
                            CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, i);
                            if (cardView != null) {
                                i = R.id.exit_button;
                                CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, i);
                                if (cardView2 != null) {
                                    i = R.id.get_prize_button;
                                    CardView cardView3 = (CardView) ViewBindings.findChildViewById(rootView, i);
                                    if (cardView3 != null) {
                                        i = R.id.get_prize_glass;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                        if (imageView3 != null) {
                                            i = R.id.instant_open_container;
                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (constraintLayout3 != null) {
                                                i = R.id.instant_open_container_ic;
                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                if (imageView4 != null) {
                                                    i = R.id.item_rarity_glow;
                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                    if (imageView5 != null) {
                                                        i = R.id.open_case_button;
                                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                        if (constraintLayout4 != null) {
                                                            i = R.id.possible_awards_rc;
                                                            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                            if (recyclerView2 != null) {
                                                                i = R.id.prize_container;
                                                                ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                if (constraintLayout5 != null) {
                                                                    i = R.id.prize_ic;
                                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (imageView6 != null) {
                                                                        i = R.id.prize_joke;
                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (textView2 != null) {
                                                                            i = R.id.prize_name;
                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (textView3 != null) {
                                                                                i = R.id.prize_page;
                                                                                ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                if (constraintLayout6 != null) {
                                                                                    i = R.id.prize_rarity_stick;
                                                                                    CardView cardView4 = (CardView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (cardView4 != null) {
                                                                                        i = R.id.secret_prize_text;
                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (textView4 != null) {
                                                                                            i = R.id.tvInstantOpen;
                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (textView5 != null) {
                                                                                                return new CaseRouletteBinding(constraintLayout2, imageView, imageView2, textView, constraintLayout, constraintLayout2, recyclerView, cardView, cardView2, cardView3, imageView3, constraintLayout3, imageView4, imageView5, constraintLayout4, recyclerView2, constraintLayout5, imageView6, textView2, textView3, constraintLayout6, cardView4, textView4, textView5);
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
