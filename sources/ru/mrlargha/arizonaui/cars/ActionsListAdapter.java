package ru.mrlargha.arizonaui.cars;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.arizona.common.utils.EasyAnimation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.cars.CarsScreen;
import ru.mrlargha.arizonaui.databinding.CarsActionItemBinding;
/* compiled from: ActionsListAdapter.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0015\u0016\u0017B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tJ\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/mrlargha/arizonaui/cars/ActionsListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/arizonaui/cars/CarsScreen$Companion$ActionButtonInfo;", "Lru/mrlargha/arizonaui/cars/ActionsListAdapter$ViewHolder;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "actionClickListener", "Lru/mrlargha/arizonaui/cars/ActionsListAdapter$OnActionClickListener;", "setOnActionClickListener", "", "onActionClickListener", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "OnActionClickListener", "Companion", "ViewHolder", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActionsListAdapter extends ListAdapter<CarsScreen.Companion.ActionButtonInfo, ViewHolder> {
    private OnActionClickListener actionClickListener;
    private final Activity activity;
    public static final Companion Companion = new Companion(null);
    private static final ActionsListAdapter$Companion$COMPARATOR$1 COMPARATOR = new DiffUtil.ItemCallback<CarsScreen.Companion.ActionButtonInfo>() { // from class: ru.mrlargha.arizonaui.cars.ActionsListAdapter$Companion$COMPARATOR$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(CarsScreen.Companion.ActionButtonInfo oldItem, CarsScreen.Companion.ActionButtonInfo newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getId() == newItem.getId();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(CarsScreen.Companion.ActionButtonInfo oldItem, CarsScreen.Companion.ActionButtonInfo newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };

    /* compiled from: ActionsListAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lru/mrlargha/arizonaui/cars/ActionsListAdapter$OnActionClickListener;", "", "onActionClickListener", "", "id", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnActionClickListener {
        void onActionClickListener(int i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionsListAdapter(Activity activity) {
        super(COMPARATOR);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
    }

    public final void setOnActionClickListener(OnActionClickListener onActionClickListener) {
        Intrinsics.checkNotNullParameter(onActionClickListener, "onActionClickListener");
        this.actionClickListener = onActionClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.cars_action_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        CarsActionItemBinding binding = holder.getBinding();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        double d = 100;
        binding.carsActionItem.getLayoutParams().width = (int) ((i2 * 8.85d) / d);
        binding.carsActionItem.getLayoutParams().height = (int) ((i3 * 6.94d) / d);
        final CarsScreen.Companion.ActionButtonInfo item = getItem(i);
        binding.itemValue.setText(item.getTitle());
        String icon = item.getIcon();
        switch (icon.hashCode()) {
            case -2013429975:
                if (icon.equals("icon-person")) {
                    binding.itemIc.setImageResource(R.drawable.cars_icon_person);
                    break;
                }
                break;
            case -1436734235:
                if (icon.equals("icon-pass")) {
                    binding.itemIc.setImageResource(R.drawable.cars_icon_pass);
                    break;
                }
                break;
            case -1346933079:
                if (icon.equals("icon-racing-car")) {
                    binding.itemIc.setImageResource(R.drawable.cars_icon_racing_car);
                    break;
                }
                break;
            case -739091114:
                if (icon.equals("icon-gps")) {
                    binding.itemIc.setImageResource(R.drawable.cars_icon_gps);
                    break;
                }
                break;
            case -739087605:
                if (icon.equals("icon-key")) {
                    binding.itemIc.setImageResource(R.drawable.cars_icon_key);
                    break;
                }
                break;
            case 1893419620:
                if (icon.equals("icon-parking")) {
                    binding.itemIc.setImageResource(R.drawable.cars_icon_parking);
                    break;
                }
                break;
            case 1947036816:
                if (icon.equals("icon-dollar")) {
                    binding.itemIc.setImageResource(R.drawable.cars_icon_dollar);
                    break;
                }
                break;
        }
        EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
        ConstraintLayout carsActionItem = binding.carsActionItem;
        Intrinsics.checkNotNullExpressionValue(carsActionItem, "carsActionItem");
        EasyAnimation.animateClick$default(easyAnimation, carsActionItem, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.cars.ActionsListAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit onBindViewHolder$lambda$1$lambda$0;
                onBindViewHolder$lambda$1$lambda$0 = ActionsListAdapter.onBindViewHolder$lambda$1$lambda$0(ActionsListAdapter.this, item);
                return onBindViewHolder$lambda$1$lambda$0;
            }
        }, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$1$lambda$0(ActionsListAdapter actionsListAdapter, CarsScreen.Companion.ActionButtonInfo actionButtonInfo) {
        OnActionClickListener onActionClickListener = actionsListAdapter.actionClickListener;
        if (onActionClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionClickListener");
            onActionClickListener = null;
        }
        onActionClickListener.onActionClickListener(actionButtonInfo.getId());
        return Unit.INSTANCE;
    }

    /* compiled from: ActionsListAdapter.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/arizonaui/cars/ActionsListAdapter$Companion;", "", "<init>", "()V", "COMPARATOR", "ru/mrlargha/arizonaui/cars/ActionsListAdapter$Companion$COMPARATOR$1", "Lru/mrlargha/arizonaui/cars/ActionsListAdapter$Companion$COMPARATOR$1;", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: ActionsListAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/cars/ActionsListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/arizonaui/databinding/CarsActionItemBinding;", "getBinding", "()Lru/mrlargha/arizonaui/databinding/CarsActionItemBinding;", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final CarsActionItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            CarsActionItemBinding bind = CarsActionItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final CarsActionItemBinding getBinding() {
            return this.binding;
        }
    }
}
