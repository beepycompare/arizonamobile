package ru.mrlargha.commonui.elements.donate.presentation.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.DonateBadgesItemBinding;
import ru.mrlargha.commonui.databinding.DonateBadgesTimeItemBinding;
import ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateBadgesAdapter;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateBadgesModelUi;
import ru.mrlargha.commonui.elements.donate.utils.DonateUtilsKt;
/* compiled from: DonateBadgesAdapter.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0010\u0011\u0012B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBadgesAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBadgesModelUi;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemViewType", "DonateBadgesViewHolder", "DonateBadgesTimeViewHolder", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateBadgesAdapter extends ListAdapter<DonateBadgesModelUi, RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion(null);
    private static final DonateBadgesAdapter$Companion$diffUtilCallback$1 diffUtilCallback = new DiffUtil.ItemCallback<DonateBadgesModelUi>() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateBadgesAdapter$Companion$diffUtilCallback$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(DonateBadgesModelUi oldItem, DonateBadgesModelUi newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(DonateBadgesModelUi oldItem, DonateBadgesModelUi newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getText(), newItem.getText());
        }
    };

    public DonateBadgesAdapter() {
        super(diffUtilCallback);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        DonateBadgesItemBinding inflate = DonateBadgesItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        DonateBadgesTimeItemBinding inflate2 = DonateBadgesTimeItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
        if (i == Companion.BadgesType.TIME.getType()) {
            return new DonateBadgesTimeViewHolder(inflate2);
        }
        return new DonateBadgesViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof DonateBadgesViewHolder) {
            DonateBadgesModelUi donateBadgesModelUi = getCurrentList().get(i);
            Intrinsics.checkNotNullExpressionValue(donateBadgesModelUi, "get(...)");
            ((DonateBadgesViewHolder) holder).onBind(donateBadgesModelUi);
        } else if (holder instanceof DonateBadgesTimeViewHolder) {
            DonateBadgesModelUi donateBadgesModelUi2 = getCurrentList().get(i);
            Intrinsics.checkNotNullExpressionValue(donateBadgesModelUi2, "get(...)");
            ((DonateBadgesTimeViewHolder) holder).onBind(donateBadgesModelUi2);
        }
    }

    /* compiled from: DonateBadgesAdapter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBadgesAdapter$DonateBadgesViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/DonateBadgesItemBinding;", "<init>", "(Lru/mrlargha/commonui/databinding/DonateBadgesItemBinding;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/DonateBadgesItemBinding;", "onBind", "", CommonUrlParts.MODEL, "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBadgesModelUi;", "(Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBadgesModelUi;)Lkotlin/Unit;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DonateBadgesViewHolder extends RecyclerView.ViewHolder {
        private final DonateBadgesItemBinding binding;

        public final DonateBadgesItemBinding getBinding() {
            return this.binding;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DonateBadgesViewHolder(DonateBadgesItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final Unit onBind(DonateBadgesModelUi model) {
            Intrinsics.checkNotNullParameter(model, "model");
            DonateBadgesItemBinding donateBadgesItemBinding = this.binding;
            TextView textView = donateBadgesItemBinding.tvTitle;
            String decodeEmoji = DonateUtilsKt.decodeEmoji(model.getIcon());
            textView.setText(decodeEmoji + " " + model.getText());
            Context context = donateBadgesItemBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            Drawable buttonsGradientDrawable = DonateUtilsKt.getButtonsGradientDrawable(context, model.getColors());
            if (buttonsGradientDrawable != null) {
                donateBadgesItemBinding.tvTitle.setBackground(buttonsGradientDrawable);
                return Unit.INSTANCE;
            }
            return null;
        }
    }

    /* compiled from: DonateBadgesAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBadgesAdapter$DonateBadgesTimeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/DonateBadgesTimeItemBinding;", "<init>", "(Lru/mrlargha/commonui/databinding/DonateBadgesTimeItemBinding;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/DonateBadgesTimeItemBinding;", "onBind", "", CommonUrlParts.MODEL, "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBadgesModelUi;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DonateBadgesTimeViewHolder extends RecyclerView.ViewHolder {
        private final DonateBadgesTimeItemBinding binding;

        public final DonateBadgesTimeItemBinding getBinding() {
            return this.binding;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DonateBadgesTimeViewHolder(DonateBadgesTimeItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final Object onBind(DonateBadgesModelUi model) {
            Intrinsics.checkNotNullParameter(model, "model");
            final DonateBadgesTimeItemBinding donateBadgesTimeItemBinding = this.binding;
            String timeHM = DonateUtilsKt.getTimeHM(Long.parseLong(model.getText()));
            if (timeHM != null) {
                LinearLayout root = donateBadgesTimeItemBinding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                root.setVisibility(0);
                donateBadgesTimeItemBinding.tvLeftTime.setText(timeHM);
                return Unit.INSTANCE;
            }
            return new Function0() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateBadgesAdapter$DonateBadgesTimeViewHolder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit onBind$lambda$2$lambda$1;
                    onBind$lambda$2$lambda$1 = DonateBadgesAdapter.DonateBadgesTimeViewHolder.onBind$lambda$2$lambda$1(DonateBadgesTimeItemBinding.this);
                    return onBind$lambda$2$lambda$1;
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onBind$lambda$2$lambda$1(DonateBadgesTimeItemBinding donateBadgesTimeItemBinding) {
            LinearLayout root = donateBadgesTimeItemBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            root.setVisibility(8);
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        Object obj;
        Iterator<E> it = Companion.BadgesType.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((Companion.BadgesType) obj).name(), getCurrentList().get(i).getIcon())) {
                break;
            }
        }
        Companion.BadgesType badgesType = (Companion.BadgesType) obj;
        if (badgesType == null) {
            badgesType = Companion.BadgesType.DEFAULT;
        }
        return badgesType.getType();
    }

    /* compiled from: DonateBadgesAdapter.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0004*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBadgesAdapter$Companion;", "", "<init>", "()V", "diffUtilCallback", "ru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBadgesAdapter$Companion$diffUtilCallback$1", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBadgesAdapter$Companion$diffUtilCallback$1;", "BadgesType", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: DonateBadgesAdapter.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBadgesAdapter$Companion$BadgesType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "DEFAULT", "TIME", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class BadgesType {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ BadgesType[] $VALUES;
            public static final BadgesType DEFAULT = new BadgesType("DEFAULT", 0, 0);
            public static final BadgesType TIME = new BadgesType("TIME", 1, 1);
            private final int type;

            private static final /* synthetic */ BadgesType[] $values() {
                return new BadgesType[]{DEFAULT, TIME};
            }

            public static EnumEntries<BadgesType> getEntries() {
                return $ENTRIES;
            }

            public static BadgesType valueOf(String str) {
                return (BadgesType) Enum.valueOf(BadgesType.class, str);
            }

            public static BadgesType[] values() {
                return (BadgesType[]) $VALUES.clone();
            }

            private BadgesType(String str, int i, int i2) {
                this.type = i2;
            }

            public final int getType() {
                return this.type;
            }

            static {
                BadgesType[] $values = $values();
                $VALUES = $values;
                $ENTRIES = EnumEntriesKt.enumEntries($values);
            }
        }

        private Companion() {
        }
    }
}
