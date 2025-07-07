package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.tabs.TabLayout;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class GamePassScreen2022Binding implements ViewBinding {
    public final AppCompatImageView award1Img;
    public final TextView award1Label;
    public final AppCompatImageView award2Img;
    public final TextView award2Label;
    public final AppCompatImageView award3Img;
    public final TextView award3Label;
    public final AppCompatImageView award4Img;
    public final TextView award4Label;
    public final AppCompatButton buyGoldPassButton;
    public final AppCompatButton buyStandardPassButton;
    public final Button changeQuestButton;
    public final AppCompatImageView closeMainPassButton;
    public final AppCompatButton completeQuestButton;
    public final AppCompatImageView goldPassButton;
    public final AppCompatImageView goldPassIndicator;
    public final ConstraintLayout gp2022Root;
    public final Guideline guideline11;
    public final Guideline guideline12;
    public final Guideline guideline13;
    public final Guideline guideline14;
    public final Guideline guideline15;
    public final Guideline guideline16;
    public final Guideline guideline17;
    public final Guideline guideline18;
    public final Guideline guideline19;
    public final Guideline guideline20;
    public final Guideline guideline21;
    public final Guideline guideline22;
    public final AppCompatImageView imageView14;
    public final AppCompatImageView imageView15;
    public final AppCompatImageView imageView16;
    public final AppCompatImageView imageView18;
    public final AppCompatImageView imageView19;
    public final AppCompatImageView imageView20;
    public final AppCompatImageView imageView6;
    public final ProgressBar progressBar;
    public final TextView questCompletePercent;
    public final TextView questDescription;
    public final AppCompatImageView questImage;
    public final TextView questProgress;
    public final TextView questTitle;
    public final Group questViewGroup;
    public final Group ratingGroup;
    public final RecyclerView ratingRecycler;
    public final RecyclerView recycler;
    private final ConstraintLayout rootView;
    public final RecyclerView serversRatingRecycler;
    public final TabLayout tabLayout;
    public final Group taskUnavailableGroup;
    public final TextView taskUnavailableStatus;
    public final TextView textView12;
    public final TextView textView16;
    public final TextView textView17;
    public final TextView textView18;
    public final TextView textView22;

    private GamePassScreen2022Binding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, TextView textView, AppCompatImageView appCompatImageView2, TextView textView2, AppCompatImageView appCompatImageView3, TextView textView3, AppCompatImageView appCompatImageView4, TextView textView4, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, Button button, AppCompatImageView appCompatImageView5, AppCompatButton appCompatButton3, AppCompatImageView appCompatImageView6, AppCompatImageView appCompatImageView7, ConstraintLayout constraintLayout2, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, Guideline guideline6, Guideline guideline7, Guideline guideline8, Guideline guideline9, Guideline guideline10, Guideline guideline11, Guideline guideline12, AppCompatImageView appCompatImageView8, AppCompatImageView appCompatImageView9, AppCompatImageView appCompatImageView10, AppCompatImageView appCompatImageView11, AppCompatImageView appCompatImageView12, AppCompatImageView appCompatImageView13, AppCompatImageView appCompatImageView14, ProgressBar progressBar, TextView textView5, TextView textView6, AppCompatImageView appCompatImageView15, TextView textView7, TextView textView8, Group group, Group group2, RecyclerView recyclerView, RecyclerView recyclerView2, RecyclerView recyclerView3, TabLayout tabLayout, Group group3, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14) {
        this.rootView = constraintLayout;
        this.award1Img = appCompatImageView;
        this.award1Label = textView;
        this.award2Img = appCompatImageView2;
        this.award2Label = textView2;
        this.award3Img = appCompatImageView3;
        this.award3Label = textView3;
        this.award4Img = appCompatImageView4;
        this.award4Label = textView4;
        this.buyGoldPassButton = appCompatButton;
        this.buyStandardPassButton = appCompatButton2;
        this.changeQuestButton = button;
        this.closeMainPassButton = appCompatImageView5;
        this.completeQuestButton = appCompatButton3;
        this.goldPassButton = appCompatImageView6;
        this.goldPassIndicator = appCompatImageView7;
        this.gp2022Root = constraintLayout2;
        this.guideline11 = guideline;
        this.guideline12 = guideline2;
        this.guideline13 = guideline3;
        this.guideline14 = guideline4;
        this.guideline15 = guideline5;
        this.guideline16 = guideline6;
        this.guideline17 = guideline7;
        this.guideline18 = guideline8;
        this.guideline19 = guideline9;
        this.guideline20 = guideline10;
        this.guideline21 = guideline11;
        this.guideline22 = guideline12;
        this.imageView14 = appCompatImageView8;
        this.imageView15 = appCompatImageView9;
        this.imageView16 = appCompatImageView10;
        this.imageView18 = appCompatImageView11;
        this.imageView19 = appCompatImageView12;
        this.imageView20 = appCompatImageView13;
        this.imageView6 = appCompatImageView14;
        this.progressBar = progressBar;
        this.questCompletePercent = textView5;
        this.questDescription = textView6;
        this.questImage = appCompatImageView15;
        this.questProgress = textView7;
        this.questTitle = textView8;
        this.questViewGroup = group;
        this.ratingGroup = group2;
        this.ratingRecycler = recyclerView;
        this.recycler = recyclerView2;
        this.serversRatingRecycler = recyclerView3;
        this.tabLayout = tabLayout;
        this.taskUnavailableGroup = group3;
        this.taskUnavailableStatus = textView9;
        this.textView12 = textView10;
        this.textView16 = textView11;
        this.textView17 = textView12;
        this.textView18 = textView13;
        this.textView22 = textView14;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static GamePassScreen2022Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static GamePassScreen2022Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.game_pass_screen_2022, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static GamePassScreen2022Binding bind(View view) {
        int i = R.id.award1_img;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null) {
            i = R.id.award1_label;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.award2_img;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                if (appCompatImageView2 != null) {
                    i = R.id.award2_label;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.award3_img;
                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                        if (appCompatImageView3 != null) {
                            i = R.id.award3_label;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.award4_img;
                                AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                if (appCompatImageView4 != null) {
                                    i = R.id.award4_label;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.buy_gold_pass_button;
                                        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
                                        if (appCompatButton != null) {
                                            i = R.id.buy_standard_pass_button;
                                            AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, i);
                                            if (appCompatButton2 != null) {
                                                i = R.id.change_quest_button;
                                                Button button = (Button) ViewBindings.findChildViewById(view, i);
                                                if (button != null) {
                                                    i = R.id.close_main_pass_button;
                                                    AppCompatImageView appCompatImageView5 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                                    if (appCompatImageView5 != null) {
                                                        i = R.id.complete_quest_button;
                                                        AppCompatButton appCompatButton3 = (AppCompatButton) ViewBindings.findChildViewById(view, i);
                                                        if (appCompatButton3 != null) {
                                                            i = R.id.gold_pass_button;
                                                            AppCompatImageView appCompatImageView6 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                                            if (appCompatImageView6 != null) {
                                                                i = R.id.goldPassIndicator;
                                                                AppCompatImageView appCompatImageView7 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                                                if (appCompatImageView7 != null) {
                                                                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                                    i = R.id.guideline11;
                                                                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                    if (guideline != null) {
                                                                        i = R.id.guideline12;
                                                                        Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                        if (guideline2 != null) {
                                                                            i = R.id.guideline13;
                                                                            Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                            if (guideline3 != null) {
                                                                                i = R.id.guideline14;
                                                                                Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                if (guideline4 != null) {
                                                                                    i = R.id.guideline15;
                                                                                    Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                    if (guideline5 != null) {
                                                                                        i = R.id.guideline16;
                                                                                        Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                        if (guideline6 != null) {
                                                                                            i = R.id.guideline17;
                                                                                            Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                            if (guideline7 != null) {
                                                                                                i = R.id.guideline18;
                                                                                                Guideline guideline8 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                if (guideline8 != null) {
                                                                                                    i = R.id.guideline19;
                                                                                                    Guideline guideline9 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                    if (guideline9 != null) {
                                                                                                        i = R.id.guideline20;
                                                                                                        Guideline guideline10 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                        if (guideline10 != null) {
                                                                                                            i = R.id.guideline21;
                                                                                                            Guideline guideline11 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                            if (guideline11 != null) {
                                                                                                                i = R.id.guideline22;
                                                                                                                Guideline guideline12 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                if (guideline12 != null) {
                                                                                                                    i = R.id.imageView14;
                                                                                                                    AppCompatImageView appCompatImageView8 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (appCompatImageView8 != null) {
                                                                                                                        i = R.id.imageView15;
                                                                                                                        AppCompatImageView appCompatImageView9 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (appCompatImageView9 != null) {
                                                                                                                            i = R.id.imageView16;
                                                                                                                            AppCompatImageView appCompatImageView10 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (appCompatImageView10 != null) {
                                                                                                                                i = R.id.imageView18;
                                                                                                                                AppCompatImageView appCompatImageView11 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (appCompatImageView11 != null) {
                                                                                                                                    i = R.id.imageView19;
                                                                                                                                    AppCompatImageView appCompatImageView12 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (appCompatImageView12 != null) {
                                                                                                                                        i = R.id.imageView20;
                                                                                                                                        AppCompatImageView appCompatImageView13 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (appCompatImageView13 != null) {
                                                                                                                                            i = R.id.imageView6;
                                                                                                                                            AppCompatImageView appCompatImageView14 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (appCompatImageView14 != null) {
                                                                                                                                                i = R.id.progressBar;
                                                                                                                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (progressBar != null) {
                                                                                                                                                    i = R.id.quest_complete_percent;
                                                                                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (textView5 != null) {
                                                                                                                                                        i = R.id.quest_description;
                                                                                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (textView6 != null) {
                                                                                                                                                            i = R.id.quest_image;
                                                                                                                                                            AppCompatImageView appCompatImageView15 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (appCompatImageView15 != null) {
                                                                                                                                                                i = R.id.quest_progress;
                                                                                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (textView7 != null) {
                                                                                                                                                                    i = R.id.quest_title;
                                                                                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (textView8 != null) {
                                                                                                                                                                        i = R.id.quest_view_group;
                                                                                                                                                                        Group group = (Group) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                        if (group != null) {
                                                                                                                                                                            i = R.id.rating_group;
                                                                                                                                                                            Group group2 = (Group) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                            if (group2 != null) {
                                                                                                                                                                                i = R.id.rating_recycler;
                                                                                                                                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                if (recyclerView != null) {
                                                                                                                                                                                    i = R.id.recycler;
                                                                                                                                                                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                    if (recyclerView2 != null) {
                                                                                                                                                                                        i = R.id.servers_rating_recycler;
                                                                                                                                                                                        RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                        if (recyclerView3 != null) {
                                                                                                                                                                                            i = R.id.tabLayout;
                                                                                                                                                                                            TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                            if (tabLayout != null) {
                                                                                                                                                                                                i = R.id.task_unavailable_group;
                                                                                                                                                                                                Group group3 = (Group) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                if (group3 != null) {
                                                                                                                                                                                                    i = R.id.task_unavailable_status;
                                                                                                                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                    if (textView9 != null) {
                                                                                                                                                                                                        i = R.id.textView12;
                                                                                                                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                        if (textView10 != null) {
                                                                                                                                                                                                            i = R.id.textView16;
                                                                                                                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                            if (textView11 != null) {
                                                                                                                                                                                                                i = R.id.textView17;
                                                                                                                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                if (textView12 != null) {
                                                                                                                                                                                                                    i = R.id.textView18;
                                                                                                                                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                    if (textView13 != null) {
                                                                                                                                                                                                                        i = R.id.textView22;
                                                                                                                                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                        if (textView14 != null) {
                                                                                                                                                                                                                            return new GamePassScreen2022Binding(constraintLayout, appCompatImageView, textView, appCompatImageView2, textView2, appCompatImageView3, textView3, appCompatImageView4, textView4, appCompatButton, appCompatButton2, button, appCompatImageView5, appCompatButton3, appCompatImageView6, appCompatImageView7, constraintLayout, guideline, guideline2, guideline3, guideline4, guideline5, guideline6, guideline7, guideline8, guideline9, guideline10, guideline11, guideline12, appCompatImageView8, appCompatImageView9, appCompatImageView10, appCompatImageView11, appCompatImageView12, appCompatImageView13, appCompatImageView14, progressBar, textView5, textView6, appCompatImageView15, textView7, textView8, group, group2, recyclerView, recyclerView2, recyclerView3, tabLayout, group3, textView9, textView10, textView11, textView12, textView13, textView14);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
