package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class GhettoWarItemBinding implements ViewBinding {
    public final LinearLayout atk1;
    public final LinearLayout atk2;
    public final LinearLayout atk3;
    public final TextView attack1;
    public final TextView attack2;
    public final TextView attack3;
    public final TextView battles;
    public final CardView card1;
    public final CardView card2;
    public final LinearLayout container0;
    public final LinearLayout container1;
    public final LinearLayout container2;
    public final TextView deffence1;
    public final TextView deffence2;
    public final TextView deffence3;
    public final TextView emptyList;
    public final TextView info1;
    public final TextView info11;
    public final TextView info2;
    public final TextView info22;
    public final TextView info3;
    public final TextView info33;
    public final TextView infoNone;
    public final TextView item2Title;
    public final TextView itemDesc;
    public final TextView itemTitle;
    public final ImageView level2Image;
    public final ImageView level2ImageBg;
    public final ImageView levelImage;
    private final LinearLayout rootView;
    public final TextView terrs;
    public final TextView timeText1;
    public final TextView timeText2;
    public final TextView timeText3;
    public final TextView titleHint;

    private GhettoWarItemBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView, TextView textView2, TextView textView3, TextView textView4, CardView cardView, CardView cardView2, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView19, TextView textView20, TextView textView21, TextView textView22, TextView textView23) {
        this.rootView = linearLayout;
        this.atk1 = linearLayout2;
        this.atk2 = linearLayout3;
        this.atk3 = linearLayout4;
        this.attack1 = textView;
        this.attack2 = textView2;
        this.attack3 = textView3;
        this.battles = textView4;
        this.card1 = cardView;
        this.card2 = cardView2;
        this.container0 = linearLayout5;
        this.container1 = linearLayout6;
        this.container2 = linearLayout7;
        this.deffence1 = textView5;
        this.deffence2 = textView6;
        this.deffence3 = textView7;
        this.emptyList = textView8;
        this.info1 = textView9;
        this.info11 = textView10;
        this.info2 = textView11;
        this.info22 = textView12;
        this.info3 = textView13;
        this.info33 = textView14;
        this.infoNone = textView15;
        this.item2Title = textView16;
        this.itemDesc = textView17;
        this.itemTitle = textView18;
        this.level2Image = imageView;
        this.level2ImageBg = imageView2;
        this.levelImage = imageView3;
        this.terrs = textView19;
        this.timeText1 = textView20;
        this.timeText2 = textView21;
        this.timeText3 = textView22;
        this.titleHint = textView23;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static GhettoWarItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static GhettoWarItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.ghetto_war_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static GhettoWarItemBinding bind(View view) {
        int i = R.id.atk1;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.atk2;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                i = R.id.atk3;
                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout3 != null) {
                    i = R.id.attack1;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.attack2;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.attack3;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.battles;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = R.id.card1;
                                    CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
                                    if (cardView != null) {
                                        i = R.id.card2;
                                        CardView cardView2 = (CardView) ViewBindings.findChildViewById(view, i);
                                        if (cardView2 != null) {
                                            i = R.id.container0;
                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout4 != null) {
                                                i = R.id.container1;
                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout5 != null) {
                                                    i = R.id.container2;
                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout6 != null) {
                                                        i = R.id.deffence1;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView5 != null) {
                                                            i = R.id.deffence2;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView6 != null) {
                                                                i = R.id.deffence3;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView7 != null) {
                                                                    i = R.id.empty_list;
                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView8 != null) {
                                                                        i = R.id.info1;
                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView9 != null) {
                                                                            i = R.id.info11;
                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView10 != null) {
                                                                                i = R.id.info2;
                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView11 != null) {
                                                                                    i = R.id.info22;
                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView12 != null) {
                                                                                        i = R.id.info3;
                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView13 != null) {
                                                                                            i = R.id.info33;
                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView14 != null) {
                                                                                                i = R.id.info_none;
                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView15 != null) {
                                                                                                    i = R.id.item2_title;
                                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView16 != null) {
                                                                                                        i = R.id.item_desc;
                                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView17 != null) {
                                                                                                            i = R.id.item_title;
                                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView18 != null) {
                                                                                                                i = R.id.level2_image;
                                                                                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (imageView != null) {
                                                                                                                    i = R.id.level2_image_bg;
                                                                                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (imageView2 != null) {
                                                                                                                        i = R.id.level_image;
                                                                                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (imageView3 != null) {
                                                                                                                            i = R.id.terrs;
                                                                                                                            TextView textView19 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView19 != null) {
                                                                                                                                i = R.id.time_text1;
                                                                                                                                TextView textView20 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView20 != null) {
                                                                                                                                    i = R.id.time_text2;
                                                                                                                                    TextView textView21 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (textView21 != null) {
                                                                                                                                        i = R.id.time_text3;
                                                                                                                                        TextView textView22 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (textView22 != null) {
                                                                                                                                            i = R.id.title_hint;
                                                                                                                                            TextView textView23 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (textView23 != null) {
                                                                                                                                                return new GhettoWarItemBinding((LinearLayout) view, linearLayout, linearLayout2, linearLayout3, textView, textView2, textView3, textView4, cardView, cardView2, linearLayout4, linearLayout5, linearLayout6, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, imageView, imageView2, imageView3, textView19, textView20, textView21, textView22, textView23);
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
