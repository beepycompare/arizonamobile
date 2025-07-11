package ru.mrlargha.commonui.elements.authorization.presentation.screen;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.databinding.BackgroundVideoBinding;
import ru.mrlargha.commonui.databinding.SpawnSelectorBinding;
import ru.mrlargha.commonui.elements.authorization.domain.controller.RegistrationInterfaceType;
import ru.mrlargha.commonui.elements.authorization.domain.controller.RegistrationVideoModeType;
import ru.mrlargha.commonui.elements.authorization.domain.spawn.SpawnData;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceManager;
import ru.mrlargha.commonui.elements.authorization.presentation.adapter.SpawnMenuAdapter;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: SpawnMenu.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/presentation/screen/SpawnMenu;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "spawnMenu", "Landroidx/constraintlayout/widget/ConstraintLayout;", "spawnMenuBinding", "Lru/mrlargha/commonui/databinding/SpawnSelectorBinding;", "spawnMenuAdapter", "Lru/mrlargha/commonui/elements/authorization/presentation/adapter/SpawnMenuAdapter;", "selectedLocation", "Ljava/lang/Integer;", "videoBinding", "Lru/mrlargha/commonui/databinding/BackgroundVideoBinding;", "notifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "addSpawns", "", "data", "", "setVisible", "visible", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SpawnMenu implements InterfaceController {
    private final IBackendNotifier notifier;
    private Integer selectedLocation;
    private final ConstraintLayout spawnMenu;
    private final SpawnMenuAdapter spawnMenuAdapter;
    private final SpawnSelectorBinding spawnMenuBinding;
    private final BackgroundVideoBinding videoBinding;

    public SpawnMenu(final Activity targetActivity, final int i) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.spawn_selector, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.spawnMenu = constraintLayout;
        SpawnSelectorBinding bind = SpawnSelectorBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.spawnMenuBinding = bind;
        SpawnMenuAdapter spawnMenuAdapter = new SpawnMenuAdapter(targetActivity);
        this.spawnMenuAdapter = spawnMenuAdapter;
        InterfaceController orCreateInterface = InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.VIDEO_BACKGROUND.getId(), targetActivity, i);
        Intrinsics.checkNotNull(orCreateInterface, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationVideoBackground");
        BackgroundVideoBinding mainBinding = ((RegistrationVideoBackground) orCreateInterface).getMainBinding();
        this.videoBinding = mainBinding;
        this.notifier = (IBackendNotifier) targetActivity;
        mainBinding.video.addView(bind.spawnSelector, -1, -1);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(mainBinding.video);
        constraintSet.connect(bind.spawnSelector.getId(), 1, mainBinding.video.getId(), 1);
        constraintSet.connect(bind.spawnSelector.getId(), 3, mainBinding.video.getId(), 3);
        constraintSet.connect(bind.spawnSelector.getId(), 4, mainBinding.video.getId(), 4);
        constraintSet.applyTo(mainBinding.video);
        RecyclerView recyclerView = bind.spawnSelectorRc;
        recyclerView.setAdapter(spawnMenuAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(targetActivity, 1, false));
        spawnMenuAdapter.selectedSpawnListener(new SpawnMenuAdapter.SelectedSpawnListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.SpawnMenu.2
            @Override // ru.mrlargha.commonui.elements.authorization.presentation.adapter.SpawnMenuAdapter.SelectedSpawnListener
            public void selectedSpawnListener(int i2) {
                SpawnMenu.this.selectedLocation = Integer.valueOf(i2);
                SpawnMenu.this.spawnMenuBinding.spawnSelectorStartGameButton.setBackgroundResource(R.drawable.authorization_border_red);
            }
        });
        bind.spawnSelectorStartGameButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.SpawnMenu$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpawnMenu.lambda$3$lambda$2(SpawnMenu.this, targetActivity, i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$3$lambda$2(SpawnMenu spawnMenu, Activity activity, int i, View view) {
        Integer num = spawnMenu.selectedLocation;
        if (num != null) {
            num.intValue();
            IBackendNotifier iBackendNotifier = spawnMenu.notifier;
            byte[] bytes = String.valueOf(spawnMenu.selectedLocation).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            iBackendNotifier.clickedWrapper(i, 6, 0, bytes);
            InterfaceController orCreateInterface = InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.VIDEO_BACKGROUND.getId(), activity, i);
            Intrinsics.checkNotNull(orCreateInterface, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationVideoBackground");
            ((RegistrationVideoBackground) orCreateInterface).selectVideoMode(RegistrationVideoModeType.VIDEO_HIDE);
            spawnMenu.setVisible(false);
            return;
        }
        Toast.makeText(activity, "Выберите локацию!", 0).show();
    }

    public final void addSpawns(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            this.spawnMenuAdapter.addSpawns(MapperKt.toListModel(data, SpawnData.class));
        } catch (Exception unused) {
            Log.w("SPAWN_MENU", "Ошибка при попытке распарсить json");
        }
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        this.spawnMenuBinding.spawnSelector.setVisibility(z ? 0 : 8);
    }
}
