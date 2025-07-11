package ru.mrlargha.commonui.elements.binder;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.elements.binder.BinderAdapter;
/* compiled from: CommandBinder.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lru/mrlargha/commonui/elements/binder/CommandBinder;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "activity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "back", "Landroid/widget/TextView;", "binderText", "recycler", "Landroidx/recyclerview/widget/RecyclerView;", "binderLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "bindsList", "", "Lru/mrlargha/commonui/elements/binder/BindData;", "mBinderView", "Landroid/widget/FrameLayout;", "adapter", "Lru/mrlargha/commonui/elements/binder/BinderAdapter;", "setBinderName", "", "index_binder", "name", "", "setBinderState", RemoteConfigConstants.ResponseFieldKey.STATE, "", "BinderListener", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CommandBinder extends SAMPUIElement {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "CommandBinder";
    private final BinderAdapter adapter;
    private final TextView back;
    private final ConstraintLayout binderLayout;
    private final TextView binderText;
    private final List<BindData> bindsList;
    private final FrameLayout mBinderView;
    private final RecyclerView recycler;

    /* compiled from: CommandBinder.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lru/mrlargha/commonui/elements/binder/CommandBinder$BinderListener;", "", "b_setBinderLayout", "", "b_getBinderState", "", FirebaseAnalytics.Param.INDEX, "", "b_getBinderName", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface BinderListener {
        String b_getBinderName(int i);

        boolean b_getBinderState(int i);

        void b_setBinderLayout();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommandBinder(final Activity activity, final int i) {
        super(activity, i);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.bindsList = new ArrayList();
        View inflate = getTargetActivity().getLayoutInflater().inflate(R.layout.binder_game_render, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) inflate;
        this.mBinderView = frameLayout;
        this.adapter = new BinderAdapter(new BinderAdapter.BindClickListener() { // from class: ru.mrlargha.commonui.elements.binder.CommandBinder$adapter$1
            @Override // ru.mrlargha.commonui.elements.binder.BinderAdapter.BindClickListener
            public void clicked(int i2) {
                IBackendNotifier notifier;
                notifier = CommandBinder.this.getNotifier();
                notifier.clickedWrapper(i, i2, -1);
            }
        });
        View findViewById = frameLayout.findViewById(R.id.bind_recycler);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.recycler = (RecyclerView) findViewById;
        View findViewById2 = frameLayout.findViewById(R.id.back_keyboard);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.back = (TextView) findViewById2;
        View findViewById3 = frameLayout.findViewById(R.id.binder_text);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.binderText = (TextView) findViewById3;
        View findViewById4 = frameLayout.findViewById(R.id.binder_main_input);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.binderLayout = (ConstraintLayout) findViewById4;
        View findViewById5 = frameLayout.findViewById(R.id.imageButton);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        AppCompatImageView appCompatImageView = (AppCompatImageView) findViewById5;
        for (int i2 = 0; i2 < 30; i2++) {
            BinderListener binderListener = (BinderListener) activity;
            this.bindsList.add(new BindData(i2, binderListener.b_getBinderName(i2), binderListener.b_getBinderState(i2)));
        }
        this.recycler.setAdapter(this.adapter);
        this.recycler.setLayoutManager(new GridLayoutManager((Context) activity, 2, 0, false));
        this.adapter.submitList(this.bindsList);
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.binder.CommandBinder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommandBinder._init_$lambda$0(CommandBinder.this, i, view);
            }
        });
        this.back.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.binder.CommandBinder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommandBinder._init_$lambda$1(CommandBinder.this, activity, view);
            }
        });
        addViewToConstraintLayout(this.mBinderView, -1, -1);
        setVisibility(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(CommandBinder commandBinder, int i, View view) {
        commandBinder.getNotifier().clickedWrapper(i, 30, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(CommandBinder commandBinder, Activity activity, View view) {
        commandBinder.setVisibility(false);
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.binder.CommandBinder.BinderListener");
        ((BinderListener) activity).b_setBinderLayout();
    }

    public final void setBinderName(int i, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Log.d(TAG, "setBinderName: " + i + " set name to " + name);
        this.bindsList.get(i).setBinderName(name);
        this.adapter.submitList(this.bindsList);
        this.adapter.notifyItemChanged(i);
    }

    public final void setBinderState(int i, boolean z) {
        this.bindsList.get(i).setBinderState(z);
        this.adapter.submitList(this.bindsList);
        this.adapter.notifyItemChanged(i);
    }

    /* compiled from: CommandBinder.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lru/mrlargha/commonui/elements/binder/CommandBinder$Companion;", "", "<init>", "()V", "TAG", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
