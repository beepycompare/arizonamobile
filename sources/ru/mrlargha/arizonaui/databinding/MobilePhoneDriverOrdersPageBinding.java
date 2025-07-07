package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class MobilePhoneDriverOrdersPageBinding implements ViewBinding {
    public final ConstraintLayout driverActionContainer;
    public final TextView driverAvailableOrders;
    public final TextView driverCar;
    public final ConstraintLayout driverCarInfo;
    public final TextView driverCarName;
    public final AppCompatImageView driverImage;
    public final ConstraintLayout driverInfoContainer;
    public final TextView driverJobButton;
    public final TextView driverName;
    public final TextView driverOrder;
    public final TextView driverOrderCount;
    public final ConstraintLayout driverOrderInfo;
    public final RecyclerView driverOrders;
    public final TextView driverPriority;
    public final ConstraintLayout driverPriorityInfo;
    public final TextView driverPriorityName;
    public final TextView driverRate;
    public final AppCompatImageView driverStar;
    public final ConstraintLayout mpDriverHeader;
    public final AppCompatImageView mpDriverHeaderBack;
    public final TextView mpDriverHeaderTitle;
    public final ConstraintLayout mpDriverOrdersPage;
    private final ConstraintLayout rootView;

    private MobilePhoneDriverOrdersPageBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, ConstraintLayout constraintLayout3, TextView textView3, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout4, TextView textView4, TextView textView5, TextView textView6, TextView textView7, ConstraintLayout constraintLayout5, RecyclerView recyclerView, TextView textView8, ConstraintLayout constraintLayout6, TextView textView9, TextView textView10, AppCompatImageView appCompatImageView2, ConstraintLayout constraintLayout7, AppCompatImageView appCompatImageView3, TextView textView11, ConstraintLayout constraintLayout8) {
        this.rootView = constraintLayout;
        this.driverActionContainer = constraintLayout2;
        this.driverAvailableOrders = textView;
        this.driverCar = textView2;
        this.driverCarInfo = constraintLayout3;
        this.driverCarName = textView3;
        this.driverImage = appCompatImageView;
        this.driverInfoContainer = constraintLayout4;
        this.driverJobButton = textView4;
        this.driverName = textView5;
        this.driverOrder = textView6;
        this.driverOrderCount = textView7;
        this.driverOrderInfo = constraintLayout5;
        this.driverOrders = recyclerView;
        this.driverPriority = textView8;
        this.driverPriorityInfo = constraintLayout6;
        this.driverPriorityName = textView9;
        this.driverRate = textView10;
        this.driverStar = appCompatImageView2;
        this.mpDriverHeader = constraintLayout7;
        this.mpDriverHeaderBack = appCompatImageView3;
        this.mpDriverHeaderTitle = textView11;
        this.mpDriverOrdersPage = constraintLayout8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MobilePhoneDriverOrdersPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MobilePhoneDriverOrdersPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mobile_phone_driver_orders_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MobilePhoneDriverOrdersPageBinding bind(View view) {
        int i = R.id.driver_action_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.driver_available_orders;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.driver_car;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.driver_car_info;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout2 != null) {
                        i = R.id.driver_car_name;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.driver_image;
                            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                            if (appCompatImageView != null) {
                                i = R.id.driver_info_container;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout3 != null) {
                                    i = R.id.driver_job_button;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.driver_name;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            i = R.id.driver_order;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView6 != null) {
                                                i = R.id.driver_order_count;
                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView7 != null) {
                                                    i = R.id.driver_order_info;
                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                    if (constraintLayout4 != null) {
                                                        i = R.id.driver_orders;
                                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                        if (recyclerView != null) {
                                                            i = R.id.driver_priority;
                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView8 != null) {
                                                                i = R.id.driver_priority_info;
                                                                ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                if (constraintLayout5 != null) {
                                                                    i = R.id.driver_priority_name;
                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView9 != null) {
                                                                        i = R.id.driver_rate;
                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView10 != null) {
                                                                            i = R.id.driver_star;
                                                                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                                                            if (appCompatImageView2 != null) {
                                                                                i = R.id.mp_driver_header;
                                                                                ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (constraintLayout6 != null) {
                                                                                    i = R.id.mp_driver_header_back;
                                                                                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                                                                    if (appCompatImageView3 != null) {
                                                                                        i = R.id.mp_driver_header_title;
                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView11 != null) {
                                                                                            ConstraintLayout constraintLayout7 = (ConstraintLayout) view;
                                                                                            return new MobilePhoneDriverOrdersPageBinding(constraintLayout7, constraintLayout, textView, textView2, constraintLayout2, textView3, appCompatImageView, constraintLayout3, textView4, textView5, textView6, textView7, constraintLayout4, recyclerView, textView8, constraintLayout5, textView9, textView10, appCompatImageView2, constraintLayout6, appCompatImageView3, textView11, constraintLayout7);
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
