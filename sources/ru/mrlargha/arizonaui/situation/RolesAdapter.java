package ru.mrlargha.arizonaui.situation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.arizona.common.utils.EasyAnimation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.SituationItemBinding;
import ru.mrlargha.arizonaui.situation.SituationScreen;
/* compiled from: RolesAdapter.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u0014\u0010\u0018\u001a\u00020\u000e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u001aR\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lru/mrlargha/arizonaui/situation/RolesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/situation/RolesAdapter$RoleViewHolder;", "<init>", "()V", "roles", "Ljava/util/ArrayList;", "Lru/mrlargha/arizonaui/situation/SituationScreen$Companion$RoleInfo;", "Lkotlin/collections/ArrayList;", "onRoleClickListener", "Lru/mrlargha/arizonaui/situation/RolesAdapter$OnRoleClickListener;", "context", "Landroid/content/Context;", "setOnRoleClickListener", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "addRoles", "roleList", "", "OnRoleClickListener", "RoleViewHolder", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RolesAdapter extends RecyclerView.Adapter<RoleViewHolder> {
    private Context context;
    private OnRoleClickListener onRoleClickListener;
    private final ArrayList<SituationScreen.Companion.RoleInfo> roles = new ArrayList<>();

    /* compiled from: RolesAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lru/mrlargha/arizonaui/situation/RolesAdapter$OnRoleClickListener;", "", "callback", "", "roleIndex", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnRoleClickListener {
        void callback(int i);
    }

    public final void setOnRoleClickListener(OnRoleClickListener onRoleClickListener) {
        Intrinsics.checkNotNullParameter(onRoleClickListener, "onRoleClickListener");
        this.onRoleClickListener = onRoleClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RoleViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.context = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.situation_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new RoleViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RoleViewHolder holder, final int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        SituationScreen.Companion.RoleInfo roleInfo = this.roles.get(i);
        Intrinsics.checkNotNullExpressionValue(roleInfo, "get(...)");
        final SituationScreen.Companion.RoleInfo roleInfo2 = roleInfo;
        final SituationItemBinding binding = holder.getBinding();
        binding.mainInfoTitle.setText(roleInfo2.getTitle());
        binding.rang.setText(roleInfo2.getMinRank() + " ранга");
        if (roleInfo2.getMaxSlots() > 0) {
            TextView textView = binding.freeSlotsTitle;
            int slots = roleInfo2.getSlots();
            textView.setText("Свободные слоты: " + slots + " / " + roleInfo2.getMaxSlots());
        } else {
            binding.freeSlotsTitle.setText("Свободные слоты: " + roleInfo2.getSlots() + " / ∞");
        }
        binding.fullInfo.setText(roleInfo2.getDescription());
        if (roleInfo2.isPressed()) {
            ConstraintLayout mainInfoContainer = binding.mainInfoContainer;
            Intrinsics.checkNotNullExpressionValue(mainInfoContainer, "mainInfoContainer");
            ConstraintLayout constraintLayout = mainInfoContainer;
            ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ConstraintLayout.LayoutParams layoutParams3 = layoutParams2;
            layoutParams3.topToTop = binding.situationMainContainer.getId();
            layoutParams3.bottomToBottom = -1;
            constraintLayout.setLayoutParams(layoutParams2);
            EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
            ConstraintLayout mainInfoContainer2 = binding.mainInfoContainer;
            Intrinsics.checkNotNullExpressionValue(mainInfoContainer2, "mainInfoContainer");
            EasyAnimation.slideWithFade$default(easyAnimation, mainInfoContainer2, EasyAnimation.SlideDirection.SCREEN_TO_DEFAULT, 600L, null, new Function0() { // from class: ru.mrlargha.arizonaui.situation.RolesAdapter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit onBindViewHolder$lambda$6$lambda$1;
                    onBindViewHolder$lambda$6$lambda$1 = RolesAdapter.onBindViewHolder$lambda$6$lambda$1(SituationItemBinding.this);
                    return onBindViewHolder$lambda$6$lambda$1;
                }
            }, 4, null);
            binding.infoButton.setBackgroundResource(R.drawable.situation_pressed_button_bg);
        } else {
            ConstraintLayout mainInfoContainer3 = binding.mainInfoContainer;
            Intrinsics.checkNotNullExpressionValue(mainInfoContainer3, "mainInfoContainer");
            ConstraintLayout constraintLayout2 = mainInfoContainer3;
            ViewGroup.LayoutParams layoutParams4 = constraintLayout2.getLayoutParams();
            if (layoutParams4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) layoutParams4;
            ConstraintLayout.LayoutParams layoutParams6 = layoutParams5;
            layoutParams6.bottomToBottom = binding.situationMainContainer.getId();
            layoutParams6.topToTop = -1;
            constraintLayout2.setLayoutParams(layoutParams5);
            binding.situationFullInfoContainer.setVisibility(8);
            binding.infoButton.setBackgroundResource(R.drawable.situation_not_pressed_button_bg);
        }
        switch (roleInfo2.getImageId()) {
            case 1:
                binding.situationMainContainer.setBackgroundResource(R.drawable.situation_1_img);
                break;
            case 2:
                binding.situationMainContainer.setBackgroundResource(R.drawable.situation_2_img);
                break;
            case 3:
                binding.situationMainContainer.setBackgroundResource(R.drawable.situation_3_img);
                break;
            case 4:
                binding.situationMainContainer.setBackgroundResource(R.drawable.situation_4_img);
                break;
            case 5:
                binding.situationMainContainer.setBackgroundResource(R.drawable.situation_5_img);
                break;
            case 6:
                binding.situationMainContainer.setBackgroundResource(R.drawable.situation_6_img);
                break;
            case 7:
                binding.situationMainContainer.setBackgroundResource(R.drawable.situation_7_img);
                break;
            case 8:
                binding.situationMainContainer.setBackgroundResource(R.drawable.situation_8_img);
                break;
            case 9:
                binding.situationMainContainer.setBackgroundResource(R.drawable.situation_9_img);
                break;
            case 10:
                binding.situationMainContainer.setBackgroundResource(R.drawable.situation_10_img);
                break;
            case 11:
                binding.situationMainContainer.setBackgroundResource(R.drawable.situation_11_img);
                break;
            case 12:
                binding.situationMainContainer.setBackgroundResource(R.drawable.situation_12_img);
                break;
            case 13:
                binding.situationMainContainer.setBackgroundResource(R.drawable.situation_13_img);
                break;
            case 14:
                binding.situationMainContainer.setBackgroundResource(R.drawable.situation_14_img);
                break;
        }
        EasyAnimation easyAnimation2 = EasyAnimation.INSTANCE;
        ConstraintLayout chooseButton = binding.chooseButton;
        Intrinsics.checkNotNullExpressionValue(chooseButton, "chooseButton");
        EasyAnimation.animateClick$default(easyAnimation2, chooseButton, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.situation.RolesAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit onBindViewHolder$lambda$6$lambda$3;
                onBindViewHolder$lambda$6$lambda$3 = RolesAdapter.onBindViewHolder$lambda$6$lambda$3(RolesAdapter.this, i);
                return onBindViewHolder$lambda$6$lambda$3;
            }
        }, 3, null);
        EasyAnimation easyAnimation3 = EasyAnimation.INSTANCE;
        ConstraintLayout infoButton = binding.infoButton;
        Intrinsics.checkNotNullExpressionValue(infoButton, "infoButton");
        EasyAnimation.animateClick$default(easyAnimation3, infoButton, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.situation.RolesAdapter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit onBindViewHolder$lambda$6$lambda$5;
                onBindViewHolder$lambda$6$lambda$5 = RolesAdapter.onBindViewHolder$lambda$6$lambda$5(SituationScreen.Companion.RoleInfo.this, this);
                return onBindViewHolder$lambda$6$lambda$5;
            }
        }, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$6$lambda$1(SituationItemBinding situationItemBinding) {
        situationItemBinding.situationFullInfoContainer.setVisibility(0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$6$lambda$3(RolesAdapter rolesAdapter, int i) {
        OnRoleClickListener onRoleClickListener = rolesAdapter.onRoleClickListener;
        if (onRoleClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onRoleClickListener");
            onRoleClickListener = null;
        }
        onRoleClickListener.callback(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$6$lambda$5(SituationScreen.Companion.RoleInfo roleInfo, RolesAdapter rolesAdapter) {
        roleInfo.setPressed(!roleInfo.isPressed());
        for (SituationScreen.Companion.RoleInfo roleInfo2 : rolesAdapter.roles) {
            if (roleInfo2.getImageId() != roleInfo.getImageId()) {
                roleInfo2.setPressed(false);
            }
        }
        rolesAdapter.notifyDataSetChanged();
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.roles.size();
    }

    /* compiled from: RolesAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/situation/RolesAdapter$RoleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/arizonaui/databinding/SituationItemBinding;", "getBinding", "()Lru/mrlargha/arizonaui/databinding/SituationItemBinding;", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class RoleViewHolder extends RecyclerView.ViewHolder {
        private final SituationItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RoleViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            SituationItemBinding bind = SituationItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final SituationItemBinding getBinding() {
            return this.binding;
        }
    }

    public final void addRoles(List<SituationScreen.Companion.RoleInfo> roleList) {
        Intrinsics.checkNotNullParameter(roleList, "roleList");
        this.roles.clear();
        this.roles.addAll(roleList);
        notifyDataSetChanged();
    }
}
