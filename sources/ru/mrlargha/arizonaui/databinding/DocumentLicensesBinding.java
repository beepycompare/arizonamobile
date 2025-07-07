package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class DocumentLicensesBinding implements ViewBinding {
    public final TextView advocate;
    public final TextView advocateTitle;
    public final TextView auto;
    public final TextView autoTitle;
    public final TextView boat;
    public final TextView boatTitle;
    public final TextView containerDescription;
    public final TextView dipl;
    public final LinearLayout diplContainerColumn;
    public final LinearLayout diplContainerTop;
    public final TextView diplTitle;
    public final TextView diplTop;
    public final ImageView documentsIcAdvocate;
    public final ImageView documentsIcAuto;
    public final ImageView documentsIcBoat;
    public final ImageView documentsIcDipl;
    public final ImageView documentsIcFish;
    public final ImageView documentsIcFlight;
    public final ImageView documentsIcGun;
    public final ImageView documentsIcHunt;
    public final ImageView documentsIcMech;
    public final ImageView documentsIcMiner;
    public final ImageView documentsIcMoto;
    public final ImageView documentsIcShave;
    public final ImageView documentsIcTax;
    public final ImageView documentsIcTaxi;
    public final TextView fish;
    public final TextView fishTitle;
    public final TextView flight;
    public final TextView flightTitle;
    public final TextView gun;
    public final TextView gunTitle;
    public final TextView hunt;
    public final TextView huntTitle;
    public final TextView mech;
    public final TextView mechTitle;
    public final TextView miner;
    public final TextView minerTitle;
    public final TextView moto;
    public final TextView motoTitle;
    private final ConstraintLayout rootView;
    public final TextView shave;
    public final TextView shaveTitle;
    public final LinearLayout table1;
    public final LinearLayout table2;
    public final LinearLayout table3;
    public final TextView tax;
    public final TextView taxTitle;
    public final TextView taxi;
    public final TextView taxiTitle;

    private DocumentLicensesBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView9, TextView textView10, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, ImageView imageView11, ImageView imageView12, ImageView imageView13, ImageView imageView14, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, TextView textView22, TextView textView23, TextView textView24, TextView textView25, TextView textView26, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, TextView textView27, TextView textView28, TextView textView29, TextView textView30) {
        this.rootView = constraintLayout;
        this.advocate = textView;
        this.advocateTitle = textView2;
        this.auto = textView3;
        this.autoTitle = textView4;
        this.boat = textView5;
        this.boatTitle = textView6;
        this.containerDescription = textView7;
        this.dipl = textView8;
        this.diplContainerColumn = linearLayout;
        this.diplContainerTop = linearLayout2;
        this.diplTitle = textView9;
        this.diplTop = textView10;
        this.documentsIcAdvocate = imageView;
        this.documentsIcAuto = imageView2;
        this.documentsIcBoat = imageView3;
        this.documentsIcDipl = imageView4;
        this.documentsIcFish = imageView5;
        this.documentsIcFlight = imageView6;
        this.documentsIcGun = imageView7;
        this.documentsIcHunt = imageView8;
        this.documentsIcMech = imageView9;
        this.documentsIcMiner = imageView10;
        this.documentsIcMoto = imageView11;
        this.documentsIcShave = imageView12;
        this.documentsIcTax = imageView13;
        this.documentsIcTaxi = imageView14;
        this.fish = textView11;
        this.fishTitle = textView12;
        this.flight = textView13;
        this.flightTitle = textView14;
        this.gun = textView15;
        this.gunTitle = textView16;
        this.hunt = textView17;
        this.huntTitle = textView18;
        this.mech = textView19;
        this.mechTitle = textView20;
        this.miner = textView21;
        this.minerTitle = textView22;
        this.moto = textView23;
        this.motoTitle = textView24;
        this.shave = textView25;
        this.shaveTitle = textView26;
        this.table1 = linearLayout3;
        this.table2 = linearLayout4;
        this.table3 = linearLayout5;
        this.tax = textView27;
        this.taxTitle = textView28;
        this.taxi = textView29;
        this.taxiTitle = textView30;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DocumentLicensesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DocumentLicensesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.document_licenses, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DocumentLicensesBinding bind(View view) {
        int i = R.id.advocate;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.advocate_title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.auto;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = R.id.auto_title;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView4 != null) {
                        i = R.id.boat;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView5 != null) {
                            i = R.id.boat_title;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView6 != null) {
                                i = R.id.container_description;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView7 != null) {
                                    i = R.id.dipl;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView8 != null) {
                                        i = R.id.dipl_container_column;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout != null) {
                                            i = R.id.dipl_container_top;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout2 != null) {
                                                i = R.id.dipl_title;
                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView9 != null) {
                                                    i = R.id.dipl_top;
                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView10 != null) {
                                                        i = R.id.documents_ic_advocate;
                                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView != null) {
                                                            i = R.id.documents_ic_auto;
                                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                            if (imageView2 != null) {
                                                                i = R.id.documents_ic_boat;
                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                if (imageView3 != null) {
                                                                    i = R.id.documents_ic_dipl;
                                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                    if (imageView4 != null) {
                                                                        i = R.id.documents_ic_fish;
                                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                        if (imageView5 != null) {
                                                                            i = R.id.documents_ic_flight;
                                                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                            if (imageView6 != null) {
                                                                                i = R.id.documents_ic_gun;
                                                                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                if (imageView7 != null) {
                                                                                    i = R.id.documents_ic_hunt;
                                                                                    ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                    if (imageView8 != null) {
                                                                                        i = R.id.documents_ic_mech;
                                                                                        ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                        if (imageView9 != null) {
                                                                                            i = R.id.documents_ic_miner;
                                                                                            ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                            if (imageView10 != null) {
                                                                                                i = R.id.documents_ic_moto;
                                                                                                ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                if (imageView11 != null) {
                                                                                                    i = R.id.documents_ic_shave;
                                                                                                    ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (imageView12 != null) {
                                                                                                        i = R.id.documents_ic_tax;
                                                                                                        ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (imageView13 != null) {
                                                                                                            i = R.id.documents_ic_taxi;
                                                                                                            ImageView imageView14 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (imageView14 != null) {
                                                                                                                i = R.id.fish;
                                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView11 != null) {
                                                                                                                    i = R.id.fish_title;
                                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView12 != null) {
                                                                                                                        i = R.id.flight;
                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView13 != null) {
                                                                                                                            i = R.id.flight_title;
                                                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView14 != null) {
                                                                                                                                i = R.id.gun;
                                                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView15 != null) {
                                                                                                                                    i = R.id.gun_title;
                                                                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (textView16 != null) {
                                                                                                                                        i = R.id.hunt;
                                                                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (textView17 != null) {
                                                                                                                                            i = R.id.hunt_title;
                                                                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (textView18 != null) {
                                                                                                                                                i = R.id.mech;
                                                                                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (textView19 != null) {
                                                                                                                                                    i = R.id.mech_title;
                                                                                                                                                    TextView textView20 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (textView20 != null) {
                                                                                                                                                        i = R.id.miner;
                                                                                                                                                        TextView textView21 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (textView21 != null) {
                                                                                                                                                            i = R.id.miner_title;
                                                                                                                                                            TextView textView22 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (textView22 != null) {
                                                                                                                                                                i = R.id.moto;
                                                                                                                                                                TextView textView23 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (textView23 != null) {
                                                                                                                                                                    i = R.id.moto_title;
                                                                                                                                                                    TextView textView24 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (textView24 != null) {
                                                                                                                                                                        i = R.id.shave;
                                                                                                                                                                        TextView textView25 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                        if (textView25 != null) {
                                                                                                                                                                            i = R.id.shave_title;
                                                                                                                                                                            TextView textView26 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                            if (textView26 != null) {
                                                                                                                                                                                i = R.id.table1;
                                                                                                                                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                if (linearLayout3 != null) {
                                                                                                                                                                                    i = R.id.table2;
                                                                                                                                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                    if (linearLayout4 != null) {
                                                                                                                                                                                        i = R.id.table3;
                                                                                                                                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                        if (linearLayout5 != null) {
                                                                                                                                                                                            i = R.id.tax;
                                                                                                                                                                                            TextView textView27 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                            if (textView27 != null) {
                                                                                                                                                                                                i = R.id.tax_title;
                                                                                                                                                                                                TextView textView28 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                if (textView28 != null) {
                                                                                                                                                                                                    i = R.id.taxi;
                                                                                                                                                                                                    TextView textView29 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                    if (textView29 != null) {
                                                                                                                                                                                                        i = R.id.taxi_title;
                                                                                                                                                                                                        TextView textView30 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                        if (textView30 != null) {
                                                                                                                                                                                                            return new DocumentLicensesBinding((ConstraintLayout) view, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, linearLayout, linearLayout2, textView9, textView10, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, imageView12, imageView13, imageView14, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26, linearLayout3, linearLayout4, linearLayout5, textView27, textView28, textView29, textView30);
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
