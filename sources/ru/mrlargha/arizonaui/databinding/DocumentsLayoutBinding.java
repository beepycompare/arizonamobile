package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class DocumentsLayoutBinding implements ViewBinding {
    public final DocumentsArmyBinding army;
    public final FrameLayout btnArmy;
    public final FrameLayout btnEsc;
    public final FrameLayout btnHealth;
    public final FrameLayout btnLicenses;
    public final FrameLayout btnMain;
    public final FrameLayout btnProperty;
    public final FrameLayout btnTransport;
    public final FrameLayout btnVip;
    public final ConstraintLayout documents;
    public final DocumentsHealthBinding health;
    public final ImageView icArmy;
    public final ImageView icHealth;
    public final ImageView icLicenses;
    public final ImageView icMain;
    public final ImageView icProperty;
    public final ImageView icTransport;
    public final DocumentLicensesBinding licenses;
    public final DocumentsMainBinding main;
    public final LinearLayout navBtns;
    public final DocumentsPropertyBinding property;
    private final ConstraintLayout rootView;
    public final DocumentsTransportBinding transport;
    public final DocumentsVipBinding vip;
    public final ImageView vipBg;

    private DocumentsLayoutBinding(ConstraintLayout constraintLayout, DocumentsArmyBinding documentsArmyBinding, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, FrameLayout frameLayout5, FrameLayout frameLayout6, FrameLayout frameLayout7, FrameLayout frameLayout8, ConstraintLayout constraintLayout2, DocumentsHealthBinding documentsHealthBinding, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, DocumentLicensesBinding documentLicensesBinding, DocumentsMainBinding documentsMainBinding, LinearLayout linearLayout, DocumentsPropertyBinding documentsPropertyBinding, DocumentsTransportBinding documentsTransportBinding, DocumentsVipBinding documentsVipBinding, ImageView imageView7) {
        this.rootView = constraintLayout;
        this.army = documentsArmyBinding;
        this.btnArmy = frameLayout;
        this.btnEsc = frameLayout2;
        this.btnHealth = frameLayout3;
        this.btnLicenses = frameLayout4;
        this.btnMain = frameLayout5;
        this.btnProperty = frameLayout6;
        this.btnTransport = frameLayout7;
        this.btnVip = frameLayout8;
        this.documents = constraintLayout2;
        this.health = documentsHealthBinding;
        this.icArmy = imageView;
        this.icHealth = imageView2;
        this.icLicenses = imageView3;
        this.icMain = imageView4;
        this.icProperty = imageView5;
        this.icTransport = imageView6;
        this.licenses = documentLicensesBinding;
        this.main = documentsMainBinding;
        this.navBtns = linearLayout;
        this.property = documentsPropertyBinding;
        this.transport = documentsTransportBinding;
        this.vip = documentsVipBinding;
        this.vipBg = imageView7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DocumentsLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DocumentsLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.documents_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DocumentsLayoutBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        int i = R.id.army;
        View findChildViewById3 = ViewBindings.findChildViewById(view, i);
        if (findChildViewById3 != null) {
            DocumentsArmyBinding bind = DocumentsArmyBinding.bind(findChildViewById3);
            i = R.id.btn_army;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = R.id.btn_esc;
                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout2 != null) {
                    i = R.id.btn_health;
                    FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout3 != null) {
                        i = R.id.btn_licenses;
                        FrameLayout frameLayout4 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout4 != null) {
                            i = R.id.btn_main;
                            FrameLayout frameLayout5 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                            if (frameLayout5 != null) {
                                i = R.id.btn_property;
                                FrameLayout frameLayout6 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                if (frameLayout6 != null) {
                                    i = R.id.btn_transport;
                                    FrameLayout frameLayout7 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                    if (frameLayout7 != null) {
                                        i = R.id.btn_vip;
                                        FrameLayout frameLayout8 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                        if (frameLayout8 != null) {
                                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                            i = R.id.health;
                                            View findChildViewById4 = ViewBindings.findChildViewById(view, i);
                                            if (findChildViewById4 != null) {
                                                DocumentsHealthBinding bind2 = DocumentsHealthBinding.bind(findChildViewById4);
                                                i = R.id.ic_army;
                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView != null) {
                                                    i = R.id.ic_health;
                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView2 != null) {
                                                        i = R.id.ic_licenses;
                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView3 != null) {
                                                            i = R.id.ic_main;
                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                            if (imageView4 != null) {
                                                                i = R.id.ic_property;
                                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                if (imageView5 != null) {
                                                                    i = R.id.ic_transport;
                                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                    if (imageView6 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.licenses))) != null) {
                                                                        DocumentLicensesBinding bind3 = DocumentLicensesBinding.bind(findChildViewById);
                                                                        i = R.id.main;
                                                                        View findChildViewById5 = ViewBindings.findChildViewById(view, i);
                                                                        if (findChildViewById5 != null) {
                                                                            DocumentsMainBinding bind4 = DocumentsMainBinding.bind(findChildViewById5);
                                                                            i = R.id.nav_btns;
                                                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (linearLayout != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.property))) != null) {
                                                                                DocumentsPropertyBinding bind5 = DocumentsPropertyBinding.bind(findChildViewById2);
                                                                                i = R.id.transport;
                                                                                View findChildViewById6 = ViewBindings.findChildViewById(view, i);
                                                                                if (findChildViewById6 != null) {
                                                                                    DocumentsTransportBinding bind6 = DocumentsTransportBinding.bind(findChildViewById6);
                                                                                    i = R.id.vip;
                                                                                    View findChildViewById7 = ViewBindings.findChildViewById(view, i);
                                                                                    if (findChildViewById7 != null) {
                                                                                        DocumentsVipBinding bind7 = DocumentsVipBinding.bind(findChildViewById7);
                                                                                        i = R.id.vip_bg;
                                                                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                        if (imageView7 != null) {
                                                                                            return new DocumentsLayoutBinding(constraintLayout, bind, frameLayout, frameLayout2, frameLayout3, frameLayout4, frameLayout5, frameLayout6, frameLayout7, frameLayout8, constraintLayout, bind2, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, bind3, bind4, linearLayout, bind5, bind6, bind7, imageView7);
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
