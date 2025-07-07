package ru.mrlargha.commonui.elements.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.elements.binder.BinderAdapter;
/* compiled from: BinderAdapter.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/elements/binder/BinderAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/commonui/elements/binder/BindData;", "Lru/mrlargha/commonui/elements/binder/BinderAdapter$BindDataViewHolder;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lru/mrlargha/commonui/elements/binder/BinderAdapter$BindClickListener;", "<init>", "(Lru/mrlargha/commonui/elements/binder/BinderAdapter$BindClickListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "BindDataViewHolder", "BindClickListener", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BinderAdapter extends ListAdapter<BindData, BindDataViewHolder> {
    private final BindClickListener listener;

    /* compiled from: BinderAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lru/mrlargha/commonui/elements/binder/BinderAdapter$BindClickListener;", "", "clicked", "", "id", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface BindClickListener {
        void clicked(int i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BinderAdapter(BindClickListener listener) {
        super(new BindDataDiffCallback());
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BindDataViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return BindDataViewHolder.Companion.from(this.listener, parent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BindDataViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        BindData item = getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind(item);
    }

    /* compiled from: BinderAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lru/mrlargha/commonui/elements/binder/BinderAdapter$BindDataViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lru/mrlargha/commonui/elements/binder/BinderAdapter$BindClickListener;", "itemView", "Landroid/view/View;", "<init>", "(Lru/mrlargha/commonui/elements/binder/BinderAdapter$BindClickListener;Landroid/view/View;)V", "bind", "", "item", "Lru/mrlargha/commonui/elements/binder/BindData;", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class BindDataViewHolder extends RecyclerView.ViewHolder {
        public static final Companion Companion = new Companion(null);
        private final BindClickListener listener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BindDataViewHolder(BindClickListener listener, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(listener, "listener");
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.listener = listener;
        }

        public final void bind(final BindData item) {
            Intrinsics.checkNotNullParameter(item, "item");
            View view = this.itemView;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.google.android.material.button.MaterialButton");
            MaterialButton materialButton = (MaterialButton) view;
            materialButton.setText(item.getBinderName());
            if (item.getBinderState()) {
                materialButton.setTextColor(-16711936);
            } else {
                materialButton.setTextColor(-1);
            }
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.binder.BinderAdapter$BindDataViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BinderAdapter.BindDataViewHolder.bind$lambda$1$lambda$0(BinderAdapter.BindDataViewHolder.this, item, view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$1$lambda$0(BindDataViewHolder bindDataViewHolder, BindData bindData, View view) {
            bindDataViewHolder.listener.clicked(bindData.getId());
        }

        /* compiled from: BinderAdapter.kt */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/binder/BinderAdapter$BindDataViewHolder$Companion;", "", "<init>", "()V", "from", "Lru/mrlargha/commonui/elements/binder/BinderAdapter$BindDataViewHolder;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lru/mrlargha/commonui/elements/binder/BinderAdapter$BindClickListener;", "parent", "Landroid/view/ViewGroup;", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final BindDataViewHolder from(BindClickListener listener, ViewGroup parent) {
                Intrinsics.checkNotNullParameter(listener, "listener");
                Intrinsics.checkNotNullParameter(parent, "parent");
                View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.bind_view, parent, false);
                Intrinsics.checkNotNull(inflate);
                return new BindDataViewHolder(listener, inflate);
            }
        }
    }
}
