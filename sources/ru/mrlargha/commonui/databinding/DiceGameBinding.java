package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class DiceGameBinding implements ViewBinding {
    public final ConstraintLayout bet100kButton;
    public final TextView bet100kButtonText;
    public final ConstraintLayout bet1kkButton;
    public final TextView bet1kkButtonText;
    public final ConstraintLayout bet500kButton;
    public final TextView bet500kButtonText;
    public final ConstraintLayout bet50kButton;
    public final TextView bet50kButtonText;
    public final ConstraintLayout betButton;
    public final ConstraintLayout betGroupContainer;
    public final ConstraintLayout betSumInputContainer;
    public final TextView betTitle;
    public final ConstraintLayout betWhiteButton;
    public final ConstraintLayout bidInfo;
    public final Guideline bodyTopLine;
    public final ConstraintLayout chatContainer;
    public final ConstraintLayout chatHistoryContainer;
    public final ConstraintLayout chatInputTextContainer;
    public final RecyclerView chatRecycler;
    public final Guideline chatRightLine;
    public final TextView chatTitle;
    public final AppCompatImageView clockIcon;
    public final TextView currentBet;
    public final TextView currentBetHeader;
    public final ConstraintLayout diceBetContainer;
    public final ConstraintLayout diceBetScreen;
    public final ConstraintLayout diceGame;
    public final Guideline downBorderLine;
    public final EditText enterBet;
    public final EditText enterMessage;
    public final AppCompatImageView exitButton;
    public final RecyclerView gamerRecycler;
    public final TextView gamerTurn;
    public final Guideline gamersBottomLine;
    public final ConstraintLayout gamersContainer;
    public final Guideline gamersLeftLine;
    public final TextView gamersTitle;
    public final ConstraintLayout headerContainer;
    public final Guideline headerLeftLine;
    public final Guideline headerRightLine;
    public final TextView headerTitle;
    public final Guideline headerTopLine;
    public final AppCompatImageView leftDice;
    public final TextView makeBidText;
    public final AppCompatImageView rightDice;
    private final ConstraintLayout rootView;
    public final AppCompatImageView sendButton;
    public final TextView sumOfBet;
    public final TextView sumOfBetHeader;
    public final TextView timer;
    public final TextView turnTitle;

    private DiceGameBinding(ConstraintLayout rootView, ConstraintLayout bet100kButton, TextView bet100kButtonText, ConstraintLayout bet1kkButton, TextView bet1kkButtonText, ConstraintLayout bet500kButton, TextView bet500kButtonText, ConstraintLayout bet50kButton, TextView bet50kButtonText, ConstraintLayout betButton, ConstraintLayout betGroupContainer, ConstraintLayout betSumInputContainer, TextView betTitle, ConstraintLayout betWhiteButton, ConstraintLayout bidInfo, Guideline bodyTopLine, ConstraintLayout chatContainer, ConstraintLayout chatHistoryContainer, ConstraintLayout chatInputTextContainer, RecyclerView chatRecycler, Guideline chatRightLine, TextView chatTitle, AppCompatImageView clockIcon, TextView currentBet, TextView currentBetHeader, ConstraintLayout diceBetContainer, ConstraintLayout diceBetScreen, ConstraintLayout diceGame, Guideline downBorderLine, EditText enterBet, EditText enterMessage, AppCompatImageView exitButton, RecyclerView gamerRecycler, TextView gamerTurn, Guideline gamersBottomLine, ConstraintLayout gamersContainer, Guideline gamersLeftLine, TextView gamersTitle, ConstraintLayout headerContainer, Guideline headerLeftLine, Guideline headerRightLine, TextView headerTitle, Guideline headerTopLine, AppCompatImageView leftDice, TextView makeBidText, AppCompatImageView rightDice, AppCompatImageView sendButton, TextView sumOfBet, TextView sumOfBetHeader, TextView timer, TextView turnTitle) {
        this.rootView = rootView;
        this.bet100kButton = bet100kButton;
        this.bet100kButtonText = bet100kButtonText;
        this.bet1kkButton = bet1kkButton;
        this.bet1kkButtonText = bet1kkButtonText;
        this.bet500kButton = bet500kButton;
        this.bet500kButtonText = bet500kButtonText;
        this.bet50kButton = bet50kButton;
        this.bet50kButtonText = bet50kButtonText;
        this.betButton = betButton;
        this.betGroupContainer = betGroupContainer;
        this.betSumInputContainer = betSumInputContainer;
        this.betTitle = betTitle;
        this.betWhiteButton = betWhiteButton;
        this.bidInfo = bidInfo;
        this.bodyTopLine = bodyTopLine;
        this.chatContainer = chatContainer;
        this.chatHistoryContainer = chatHistoryContainer;
        this.chatInputTextContainer = chatInputTextContainer;
        this.chatRecycler = chatRecycler;
        this.chatRightLine = chatRightLine;
        this.chatTitle = chatTitle;
        this.clockIcon = clockIcon;
        this.currentBet = currentBet;
        this.currentBetHeader = currentBetHeader;
        this.diceBetContainer = diceBetContainer;
        this.diceBetScreen = diceBetScreen;
        this.diceGame = diceGame;
        this.downBorderLine = downBorderLine;
        this.enterBet = enterBet;
        this.enterMessage = enterMessage;
        this.exitButton = exitButton;
        this.gamerRecycler = gamerRecycler;
        this.gamerTurn = gamerTurn;
        this.gamersBottomLine = gamersBottomLine;
        this.gamersContainer = gamersContainer;
        this.gamersLeftLine = gamersLeftLine;
        this.gamersTitle = gamersTitle;
        this.headerContainer = headerContainer;
        this.headerLeftLine = headerLeftLine;
        this.headerRightLine = headerRightLine;
        this.headerTitle = headerTitle;
        this.headerTopLine = headerTopLine;
        this.leftDice = leftDice;
        this.makeBidText = makeBidText;
        this.rightDice = rightDice;
        this.sendButton = sendButton;
        this.sumOfBet = sumOfBet;
        this.sumOfBetHeader = sumOfBetHeader;
        this.timer = timer;
        this.turnTitle = turnTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DiceGameBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DiceGameBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dice_game, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DiceGameBinding bind(View rootView) {
        int i = R.id.bet_100k_button;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
        if (constraintLayout != null) {
            i = R.id.bet_100k_button_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.bet_1kk_button;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                if (constraintLayout2 != null) {
                    i = R.id.bet_1kk_button_text;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.bet_500k_button;
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                        if (constraintLayout3 != null) {
                            i = R.id.bet_500k_button_text;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView3 != null) {
                                i = R.id.bet_50k_button;
                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                if (constraintLayout4 != null) {
                                    i = R.id.bet_50k_button_text;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView4 != null) {
                                        i = R.id.bet_button;
                                        ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (constraintLayout5 != null) {
                                            i = R.id.bet_group_container;
                                            ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (constraintLayout6 != null) {
                                                i = R.id.bet_sum_input_container;
                                                ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                if (constraintLayout7 != null) {
                                                    i = R.id.bet_title;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView5 != null) {
                                                        i = R.id.bet_white_button;
                                                        ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                        if (constraintLayout8 != null) {
                                                            i = R.id.bid_info;
                                                            ConstraintLayout constraintLayout9 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                            if (constraintLayout9 != null) {
                                                                i = R.id.body_top_line;
                                                                Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                if (guideline != null) {
                                                                    i = R.id.chat_container;
                                                                    ConstraintLayout constraintLayout10 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                    if (constraintLayout10 != null) {
                                                                        i = R.id.chat_history_container;
                                                                        ConstraintLayout constraintLayout11 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                        if (constraintLayout11 != null) {
                                                                            i = R.id.chat_input_text_container;
                                                                            ConstraintLayout constraintLayout12 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                            if (constraintLayout12 != null) {
                                                                                i = R.id.chat_recycler;
                                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                                if (recyclerView != null) {
                                                                                    i = R.id.chat_right_line;
                                                                                    Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (guideline2 != null) {
                                                                                        i = R.id.chat_title;
                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (textView6 != null) {
                                                                                            i = R.id.clock_icon;
                                                                                            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (appCompatImageView != null) {
                                                                                                i = R.id.current_bet;
                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (textView7 != null) {
                                                                                                    i = R.id.current_bet_header;
                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (textView8 != null) {
                                                                                                        i = R.id.dice_bet_container;
                                                                                                        ConstraintLayout constraintLayout13 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                        if (constraintLayout13 != null) {
                                                                                                            i = R.id.dice_bet_screen;
                                                                                                            ConstraintLayout constraintLayout14 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                            if (constraintLayout14 != null) {
                                                                                                                ConstraintLayout constraintLayout15 = (ConstraintLayout) rootView;
                                                                                                                i = R.id.down_border_line;
                                                                                                                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                if (guideline3 != null) {
                                                                                                                    i = R.id.enter_bet;
                                                                                                                    EditText editText = (EditText) ViewBindings.findChildViewById(rootView, i);
                                                                                                                    if (editText != null) {
                                                                                                                        i = R.id.enter_message;
                                                                                                                        EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, i);
                                                                                                                        if (editText2 != null) {
                                                                                                                            i = R.id.exit_button;
                                                                                                                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                            if (appCompatImageView2 != null) {
                                                                                                                                i = R.id.gamer_recycler;
                                                                                                                                RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                if (recyclerView2 != null) {
                                                                                                                                    i = R.id.gamer_turn;
                                                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                    if (textView9 != null) {
                                                                                                                                        i = R.id.gamers_bottom_line;
                                                                                                                                        Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                        if (guideline4 != null) {
                                                                                                                                            i = R.id.gamers_container;
                                                                                                                                            ConstraintLayout constraintLayout16 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                            if (constraintLayout16 != null) {
                                                                                                                                                i = R.id.gamers_left_line;
                                                                                                                                                Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                if (guideline5 != null) {
                                                                                                                                                    i = R.id.gamers_title;
                                                                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                    if (textView10 != null) {
                                                                                                                                                        i = R.id.header_container;
                                                                                                                                                        ConstraintLayout constraintLayout17 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                        if (constraintLayout17 != null) {
                                                                                                                                                            i = R.id.header_left_line;
                                                                                                                                                            Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                            if (guideline6 != null) {
                                                                                                                                                                i = R.id.header_right_line;
                                                                                                                                                                Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                if (guideline7 != null) {
                                                                                                                                                                    i = R.id.header_title;
                                                                                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                    if (textView11 != null) {
                                                                                                                                                                        i = R.id.header_top_line;
                                                                                                                                                                        Guideline guideline8 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                        if (guideline8 != null) {
                                                                                                                                                                            i = R.id.left_dice;
                                                                                                                                                                            AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                            if (appCompatImageView3 != null) {
                                                                                                                                                                                i = R.id.make_bid_text;
                                                                                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                if (textView12 != null) {
                                                                                                                                                                                    i = R.id.right_dice;
                                                                                                                                                                                    AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                    if (appCompatImageView4 != null) {
                                                                                                                                                                                        i = R.id.send_button;
                                                                                                                                                                                        AppCompatImageView appCompatImageView5 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                        if (appCompatImageView5 != null) {
                                                                                                                                                                                            i = R.id.sum_of_bet;
                                                                                                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                            if (textView13 != null) {
                                                                                                                                                                                                i = R.id.sum_of_bet_header;
                                                                                                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                if (textView14 != null) {
                                                                                                                                                                                                    i = R.id.timer;
                                                                                                                                                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                    if (textView15 != null) {
                                                                                                                                                                                                        i = R.id.turn_title;
                                                                                                                                                                                                        TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                                        if (textView16 != null) {
                                                                                                                                                                                                            return new DiceGameBinding(constraintLayout15, constraintLayout, textView, constraintLayout2, textView2, constraintLayout3, textView3, constraintLayout4, textView4, constraintLayout5, constraintLayout6, constraintLayout7, textView5, constraintLayout8, constraintLayout9, guideline, constraintLayout10, constraintLayout11, constraintLayout12, recyclerView, guideline2, textView6, appCompatImageView, textView7, textView8, constraintLayout13, constraintLayout14, constraintLayout15, guideline3, editText, editText2, appCompatImageView2, recyclerView2, textView9, guideline4, constraintLayout16, guideline5, textView10, constraintLayout17, guideline6, guideline7, textView11, guideline8, appCompatImageView3, textView12, appCompatImageView4, appCompatImageView5, textView13, textView14, textView15, textView16);
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
