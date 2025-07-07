package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class FamilyHomePageBinding implements ViewBinding {
    public final TextView apartTitle;
    public final CardView buttonAlliance;
    public final ImageView buttonCopyDisc;
    public final CardView buttonPayday;
    public final CardView card1;
    public final CardView cardApart;
    public final CardView cardBrend;
    public final TextView cardBrendText;
    public final CardView cardOfficial;
    public final TextView cardOfficialText;
    public final CardView charterCard;
    public final CardView discCard;
    public final TextView discDesc;
    public final ProgressBar expProgressBar;
    public final CardView idCard;
    public final TextView idText;
    public final ImageView imageApart;
    public final LinearLayout leader1;
    public final LinearLayout leader2;
    public final LinearLayout leader3;
    public final LinearLayout leader4;
    public final ConstraintLayout neighborGameTaskScreen;
    public final ImageView onlineLeader1;
    public final ImageView onlineLeader2;
    public final ImageView onlineLeader3;
    public final ImageView onlineLeader4;
    private final ConstraintLayout rootView;
    public final TextView textAlliance;
    public final TextView textApartName;
    public final TextView textApartNumber;
    public final TextView textCharter;
    public final TextView textDisc;
    public final TextView textExperience;
    public final TextView textFlag;
    public final TextView textLeader1;
    public final TextView textLeader2;
    public final TextView textLeader3;
    public final TextView textLeader4;
    public final TextView textLevel;
    public final TextView textPayday;
    public final TextView textPercent;

    private FamilyHomePageBinding(ConstraintLayout constraintLayout, TextView textView, CardView cardView, ImageView imageView, CardView cardView2, CardView cardView3, CardView cardView4, CardView cardView5, TextView textView2, CardView cardView6, TextView textView3, CardView cardView7, CardView cardView8, TextView textView4, ProgressBar progressBar, CardView cardView9, TextView textView5, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, ConstraintLayout constraintLayout2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19) {
        this.rootView = constraintLayout;
        this.apartTitle = textView;
        this.buttonAlliance = cardView;
        this.buttonCopyDisc = imageView;
        this.buttonPayday = cardView2;
        this.card1 = cardView3;
        this.cardApart = cardView4;
        this.cardBrend = cardView5;
        this.cardBrendText = textView2;
        this.cardOfficial = cardView6;
        this.cardOfficialText = textView3;
        this.charterCard = cardView7;
        this.discCard = cardView8;
        this.discDesc = textView4;
        this.expProgressBar = progressBar;
        this.idCard = cardView9;
        this.idText = textView5;
        this.imageApart = imageView2;
        this.leader1 = linearLayout;
        this.leader2 = linearLayout2;
        this.leader3 = linearLayout3;
        this.leader4 = linearLayout4;
        this.neighborGameTaskScreen = constraintLayout2;
        this.onlineLeader1 = imageView3;
        this.onlineLeader2 = imageView4;
        this.onlineLeader3 = imageView5;
        this.onlineLeader4 = imageView6;
        this.textAlliance = textView6;
        this.textApartName = textView7;
        this.textApartNumber = textView8;
        this.textCharter = textView9;
        this.textDisc = textView10;
        this.textExperience = textView11;
        this.textFlag = textView12;
        this.textLeader1 = textView13;
        this.textLeader2 = textView14;
        this.textLeader3 = textView15;
        this.textLeader4 = textView16;
        this.textLevel = textView17;
        this.textPayday = textView18;
        this.textPercent = textView19;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FamilyHomePageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FamilyHomePageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.family_home_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamilyHomePageBinding bind(View view) {
        int i = R.id.apart_title;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.button_alliance;
            CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
            if (cardView != null) {
                i = R.id.button_copy_disc;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.button_payday;
                    CardView cardView2 = (CardView) ViewBindings.findChildViewById(view, i);
                    if (cardView2 != null) {
                        i = R.id.card1;
                        CardView cardView3 = (CardView) ViewBindings.findChildViewById(view, i);
                        if (cardView3 != null) {
                            i = R.id.card_apart;
                            CardView cardView4 = (CardView) ViewBindings.findChildViewById(view, i);
                            if (cardView4 != null) {
                                i = R.id.card_brend;
                                CardView cardView5 = (CardView) ViewBindings.findChildViewById(view, i);
                                if (cardView5 != null) {
                                    i = R.id.card_brend_text;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        i = R.id.card_official;
                                        CardView cardView6 = (CardView) ViewBindings.findChildViewById(view, i);
                                        if (cardView6 != null) {
                                            i = R.id.card_official_text;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = R.id.charter_card;
                                                CardView cardView7 = (CardView) ViewBindings.findChildViewById(view, i);
                                                if (cardView7 != null) {
                                                    i = R.id.disc_card;
                                                    CardView cardView8 = (CardView) ViewBindings.findChildViewById(view, i);
                                                    if (cardView8 != null) {
                                                        i = R.id.disc_desc;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView4 != null) {
                                                            i = R.id.exp_progress_bar;
                                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                            if (progressBar != null) {
                                                                i = R.id.id_card;
                                                                CardView cardView9 = (CardView) ViewBindings.findChildViewById(view, i);
                                                                if (cardView9 != null) {
                                                                    i = R.id.id_text;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView5 != null) {
                                                                        i = R.id.image_apart;
                                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                        if (imageView2 != null) {
                                                                            i = R.id.leader1;
                                                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (linearLayout != null) {
                                                                                i = R.id.leader2;
                                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (linearLayout2 != null) {
                                                                                    i = R.id.leader3;
                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                    if (linearLayout3 != null) {
                                                                                        i = R.id.leader4;
                                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (linearLayout4 != null) {
                                                                                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                                                            i = R.id.online_leader1;
                                                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                            if (imageView3 != null) {
                                                                                                i = R.id.online_leader2;
                                                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                if (imageView4 != null) {
                                                                                                    i = R.id.online_leader3;
                                                                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (imageView5 != null) {
                                                                                                        i = R.id.online_leader4;
                                                                                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (imageView6 != null) {
                                                                                                            i = R.id.text_alliance;
                                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView6 != null) {
                                                                                                                i = R.id.text_apart_name;
                                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView7 != null) {
                                                                                                                    i = R.id.text_apart_number;
                                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView8 != null) {
                                                                                                                        i = R.id.text_charter;
                                                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView9 != null) {
                                                                                                                            i = R.id.text_disc;
                                                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView10 != null) {
                                                                                                                                i = R.id.text_experience;
                                                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView11 != null) {
                                                                                                                                    i = R.id.text_flag;
                                                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (textView12 != null) {
                                                                                                                                        i = R.id.text_leader1;
                                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (textView13 != null) {
                                                                                                                                            i = R.id.text_leader2;
                                                                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (textView14 != null) {
                                                                                                                                                i = R.id.text_leader3;
                                                                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (textView15 != null) {
                                                                                                                                                    i = R.id.text_leader4;
                                                                                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (textView16 != null) {
                                                                                                                                                        i = R.id.text_level;
                                                                                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (textView17 != null) {
                                                                                                                                                            i = R.id.text_payday;
                                                                                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (textView18 != null) {
                                                                                                                                                                i = R.id.text_percent;
                                                                                                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (textView19 != null) {
                                                                                                                                                                    return new FamilyHomePageBinding(constraintLayout, textView, cardView, imageView, cardView2, cardView3, cardView4, cardView5, textView2, cardView6, textView3, cardView7, cardView8, textView4, progressBar, cardView9, textView5, imageView2, linearLayout, linearLayout2, linearLayout3, linearLayout4, constraintLayout, imageView3, imageView4, imageView5, imageView6, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
