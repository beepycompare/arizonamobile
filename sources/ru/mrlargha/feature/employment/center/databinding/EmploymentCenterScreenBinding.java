package ru.mrlargha.feature.employment.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.employment.center.R;
/* loaded from: classes6.dex */
public final class EmploymentCenterScreenBinding implements ViewBinding {
    public final LinearLayout bg;
    public final EmploymentCenterBonusDescBinding bonusDesc;
    public final EmploymentCenterItemsTableBinding bonusesTable;
    public final ConstraintLayout easterBattlepassChoose;
    public final EmploymentCenterMainBinding main;
    private final ConstraintLayout rootView;
    public final EmploymentCenterSalaryTableBinding salaryTable;
    public final EmploymentCenterTextTableBinding textTable;
    public final EmploymentCenterTopbarBinding topbar;

    private EmploymentCenterScreenBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, EmploymentCenterBonusDescBinding employmentCenterBonusDescBinding, EmploymentCenterItemsTableBinding employmentCenterItemsTableBinding, ConstraintLayout constraintLayout2, EmploymentCenterMainBinding employmentCenterMainBinding, EmploymentCenterSalaryTableBinding employmentCenterSalaryTableBinding, EmploymentCenterTextTableBinding employmentCenterTextTableBinding, EmploymentCenterTopbarBinding employmentCenterTopbarBinding) {
        this.rootView = constraintLayout;
        this.bg = linearLayout;
        this.bonusDesc = employmentCenterBonusDescBinding;
        this.bonusesTable = employmentCenterItemsTableBinding;
        this.easterBattlepassChoose = constraintLayout2;
        this.main = employmentCenterMainBinding;
        this.salaryTable = employmentCenterSalaryTableBinding;
        this.textTable = employmentCenterTextTableBinding;
        this.topbar = employmentCenterTopbarBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static EmploymentCenterScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static EmploymentCenterScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.employment_center_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EmploymentCenterScreenBinding bind(View view) {
        View findChildViewById;
        int i = R.id.bg;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.bonus_desc))) != null) {
            EmploymentCenterBonusDescBinding bind = EmploymentCenterBonusDescBinding.bind(findChildViewById);
            i = R.id.bonuses_table;
            View findChildViewById2 = ViewBindings.findChildViewById(view, i);
            if (findChildViewById2 != null) {
                EmploymentCenterItemsTableBinding bind2 = EmploymentCenterItemsTableBinding.bind(findChildViewById2);
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.main;
                View findChildViewById3 = ViewBindings.findChildViewById(view, i);
                if (findChildViewById3 != null) {
                    EmploymentCenterMainBinding bind3 = EmploymentCenterMainBinding.bind(findChildViewById3);
                    i = R.id.salary_table;
                    View findChildViewById4 = ViewBindings.findChildViewById(view, i);
                    if (findChildViewById4 != null) {
                        EmploymentCenterSalaryTableBinding bind4 = EmploymentCenterSalaryTableBinding.bind(findChildViewById4);
                        i = R.id.text_table;
                        View findChildViewById5 = ViewBindings.findChildViewById(view, i);
                        if (findChildViewById5 != null) {
                            EmploymentCenterTextTableBinding bind5 = EmploymentCenterTextTableBinding.bind(findChildViewById5);
                            i = R.id.topbar;
                            View findChildViewById6 = ViewBindings.findChildViewById(view, i);
                            if (findChildViewById6 != null) {
                                return new EmploymentCenterScreenBinding(constraintLayout, linearLayout, bind, bind2, constraintLayout, bind3, bind4, bind5, EmploymentCenterTopbarBinding.bind(findChildViewById6));
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
