package ru.mrlargha.arizonaui.ghetto;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PointF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.GhettoMainBinding;
import ru.mrlargha.arizonaui.databinding.GhettoMapFrameBinding;
import ru.mrlargha.arizonaui.databinding.GhettoTopbarBinding;
import ru.mrlargha.arizonaui.ghetto.data.BandInfo;
import ru.mrlargha.arizonaui.ghetto.data.FrameMapData;
import ru.mrlargha.arizonaui.ghetto.data.MapData;
import ru.mrlargha.arizonaui.ghetto.data.TerritoryOrderKt;
import ru.mrlargha.arizonaui.ghetto.data.UniqData;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.ui.ArizonaRetrofit;
import ru.mrlargha.commonui.utils.ui.money.MoneyElementKt;
/* compiled from: GhettoScreen.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0002:;B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0006H\u0016J\b\u0010)\u001a\u00020\"H\u0002J\b\u0010*\u001a\u00020\"H\u0002J\u0010\u0010+\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u0017H\u0002J\u0016\u0010,\u001a\u00020\"2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020-0\u0019H\u0002J\b\u0010.\u001a\u00020\"H\u0002J\u0010\u0010/\u001a\u00020\"2\u0006\u0010&\u001a\u000200H\u0002J\b\u00101\u001a\u00020\"H\u0002J\b\u00102\u001a\u00020\"H\u0002J\u0010\u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020\u0006H\u0002J\u0010\u00105\u001a\u00020\"2\u0006\u00106\u001a\u000200H\u0002J\u0010\u00107\u001a\u00020\"2\u0006\u00108\u001a\u000209H\u0002R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lru/mrlargha/arizonaui/ghetto/GhettoScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lru/mrlargha/arizonaui/databinding/GhettoMainBinding;", "mapCells", "xMargin", "", "yMargin", "cellWidth", "cellHeight", "warsAdapter", "Lru/mrlargha/arizonaui/ghetto/WarsAdapter;", "bandInfo", "Lru/mrlargha/arizonaui/ghetto/data/BandInfo;", "mapInfo", "", "Lru/mrlargha/arizonaui/ghetto/data/MapData;", "client", "Lru/mrlargha/commonui/utils/ui/ArizonaRetrofit;", "getClient", "()Lru/mrlargha/commonui/utils/ui/ArizonaRetrofit;", "api", "Lru/mrlargha/arizonaui/ghetto/GhettoApi;", "setVisible", "", "visible", "", "onBackendMessageHandled", "data", "", "subId", "setupNavigation", "loadMapRetrofit", "setBandInfo", "setUniqCells", "Lru/mrlargha/arizonaui/ghetto/data/UniqData;", "setMap", "setFrameMap", "Lru/mrlargha/arizonaui/ghetto/data/FrameMapData;", "requestTopTerritories", "requestCaptures", "requestCapturesCount", "fraction", "selectTerritoryItem", "item", "navigateTo", "nav", "Lru/mrlargha/arizonaui/ghetto/GhettoScreen$Navigation;", "Navigation", "Spawner", "ArizonaUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class GhettoScreen extends SAMPUIElement implements InterfaceController {
    private final GhettoApi api;
    private BandInfo bandInfo;
    private final GhettoMainBinding binding;
    private final float cellHeight;
    private final float cellWidth;
    private final ArizonaRetrofit client;
    private final int mapCells;
    private List<MapData> mapInfo;
    private final View screen;
    private final WarsAdapter warsAdapter;
    private final float xMargin;
    private final float yMargin;

    /* compiled from: GhettoScreen.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Navigation.values().length];
            try {
                iArr[Navigation.War.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Navigation.Map.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GhettoScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View screen = targetActivity.getLayoutInflater().inflate(R.layout.ghetto_main, (ViewGroup) null);
        this.screen = screen;
        GhettoMainBinding bind = GhettoMainBinding.bind(screen);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.mapCells = 10;
        this.xMargin = 187.0f;
        this.yMargin = 150.0f;
        this.cellWidth = 92.0f;
        this.cellHeight = 68.0f;
        WarsAdapter warsAdapter = new WarsAdapter(new Function1() { // from class: ru.mrlargha.arizonaui.ghetto.GhettoScreen$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GhettoScreen.warsAdapter$lambda$0(GhettoScreen.this, ((Integer) obj).intValue());
            }
        });
        this.warsAdapter = warsAdapter;
        this.bandInfo = new BandInfo(-1, 0, 0, 0);
        this.mapInfo = CollectionsKt.emptyList();
        ArizonaRetrofit arizonaRetrofit = new ArizonaRetrofit(targetActivity, i);
        this.client = arizonaRetrofit;
        this.api = (GhettoApi) ArizonaRetrofit.create$default(arizonaRetrofit, GhettoApi.class, false, null, null, 14, null);
        Intrinsics.checkNotNullExpressionValue(screen, "screen");
        addViewToConstraintLayout(screen, -1, -1);
        bind.war.menuItemsRv.setAdapter(warsAdapter);
        navigateTo(Navigation.War);
        setupNavigation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit warsAdapter$lambda$0(GhettoScreen ghettoScreen, int i) {
        if (i == 4) {
            ghettoScreen.navigateTo(Navigation.Map);
        }
        return Unit.INSTANCE;
    }

    public final ArizonaRetrofit getClient() {
        return this.client;
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        this.binding.frameMap.getRoot().setVisibility(8);
        this.binding.getRoot().setVisibility(z ? 0 : 8);
        navigateTo(Navigation.War);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessageHandled(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 1) {
            setBandInfo((BandInfo) MapperKt.toModel(data, BandInfo.class));
        } else if (i != 2) {
        } else {
            setUniqCells(MapperKt.toListModel(data, UniqData.class));
        }
    }

    private final void setupNavigation() {
        this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.ghetto.GhettoScreen$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GhettoScreen.this.binding.frameMap.getRoot().setVisibility(8);
            }
        });
        this.binding.familyOverlay.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.ghetto.GhettoScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GhettoScreen.this.binding.frameMap.getRoot().setVisibility(8);
            }
        });
        this.binding.map.button.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.ghetto.GhettoScreen$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SAMPUIElement.notifyClick$default(GhettoScreen.this, 0, 1, null, 4, null);
            }
        });
        GhettoTopbarBinding ghettoTopbarBinding = this.binding.topbar;
        ghettoTopbarBinding.closeButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.ghetto.GhettoScreen$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GhettoScreen.setupNavigation$lambda$3$0(GhettoScreen.this, view);
            }
        });
        ghettoTopbarBinding.backButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.ghetto.GhettoScreen$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GhettoScreen.setupNavigation$lambda$3$1(GhettoScreen.this, view);
            }
        });
        this.binding.frameMap.buttonClose.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.ghetto.GhettoScreen$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GhettoScreen.setupNavigation$lambda$4$0(GhettoScreen.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$3$0(GhettoScreen ghettoScreen, View view) {
        SAMPUIElement.notifyClick$default(ghettoScreen, 0, 0, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$3$1(GhettoScreen ghettoScreen, View view) {
        ghettoScreen.navigateTo(Navigation.War);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$4$0(GhettoScreen ghettoScreen, View view) {
        ghettoScreen.binding.frameMap.getRoot().setVisibility(8);
    }

    private final void loadMapRetrofit() {
        BuildersKt__Builders_commonKt.launch$default(this.client.getScope(), Dispatchers.getMain(), null, new GhettoScreen$loadMapRetrofit$1(this, null), 2, null);
    }

    private final void setBandInfo(BandInfo bandInfo) {
        this.bandInfo = bandInfo;
        this.warsAdapter.setInfo(bandInfo);
        requestCapturesCount(bandInfo.getFights_count());
    }

    private final void setUniqCells(List<UniqData> list) {
        Log.d("setDataAndTryToDraw", "FRONTEND: " + list);
        GridOverlayView overlayView = this.binding.map.overlayView;
        Intrinsics.checkNotNullExpressionValue(overlayView, "overlayView");
        GridOverlayView.setDataAndTryToDraw$default(overlayView, null, list, 1, null);
    }

    private final void setMap() {
        loadMapRetrofit();
        Bitmap decodeStream = BitmapFactory.decodeStream(getTargetActivity().getResources().openRawResource(R.raw.ghetto_map));
        final SubsamplingScaleImageView subsamplingScaleImageView = this.binding.map.mapView;
        subsamplingScaleImageView.setImage(ImageSource.bitmap(decodeStream));
        subsamplingScaleImageView.setScaleAndCenter(2.0f, new PointF(this.xMargin + 300.0f, this.yMargin + 300.0f));
        subsamplingScaleImageView.setMaxScale(10.0f);
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        final int scaledTouchSlop = ViewConfiguration.get(subsamplingScaleImageView.getContext()).getScaledTouchSlop();
        subsamplingScaleImageView.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.arizonaui.ghetto.GhettoScreen$$ExternalSyntheticLambda7
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean map$lambda$0$0;
                map$lambda$0$0 = GhettoScreen.setMap$lambda$0$0(Ref.FloatRef.this, floatRef2, scaledTouchSlop, subsamplingScaleImageView, this, view, motionEvent);
                return map$lambda$0$0;
            }
        });
        GridOverlayView gridOverlayView = this.binding.map.overlayView;
        SubsamplingScaleImageView mapView = this.binding.map.mapView;
        Intrinsics.checkNotNullExpressionValue(mapView, "mapView");
        gridOverlayView.setLinkedImageView(mapView, this.mapCells, this.xMargin, this.yMargin, this.cellWidth, this.cellHeight);
        this.binding.map.mapView.setOnStateChangedListener(new SubsamplingScaleImageView.OnStateChangedListener() { // from class: ru.mrlargha.arizonaui.ghetto.GhettoScreen$setMap$2
            @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnStateChangedListener
            public void onScaleChanged(float f, int i) {
                GhettoMainBinding ghettoMainBinding;
                ghettoMainBinding = GhettoScreen.this.binding;
                ghettoMainBinding.map.overlayView.invalidate();
            }

            @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnStateChangedListener
            public void onCenterChanged(PointF newCenter, int i) {
                GhettoMainBinding ghettoMainBinding;
                Intrinsics.checkNotNullParameter(newCenter, "newCenter");
                ghettoMainBinding = GhettoScreen.this.binding;
                ghettoMainBinding.map.overlayView.invalidate();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setMap$lambda$0$0(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, int i, SubsamplingScaleImageView subsamplingScaleImageView, GhettoScreen ghettoScreen, View view, MotionEvent motionEvent) {
        PointF viewToSourceCoord;
        Object obj;
        Object obj2;
        int action = motionEvent.getAction();
        if (action == 0) {
            floatRef.element = motionEvent.getX();
            floatRef2.element = motionEvent.getY();
        } else if (action == 1) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            float f = x - floatRef.element;
            float f2 = y - floatRef2.element;
            if ((f * f) + (f2 * f2) < i * i && (viewToSourceCoord = subsamplingScaleImageView.viewToSourceCoord(x, y)) != null) {
                int i2 = (int) ((viewToSourceCoord.x - ghettoScreen.xMargin) / ghettoScreen.cellWidth);
                int i3 = (int) ((viewToSourceCoord.y - ghettoScreen.yMargin) / ghettoScreen.cellHeight);
                if (i3 >= 0) {
                    int i4 = ghettoScreen.mapCells;
                    if (i3 < i4 + 3 && i2 >= 0 && i2 < i4) {
                        Integer num = (Integer) CollectionsKt.getOrNull(TerritoryOrderKt.getTerritoryOrder(), (i3 * i4) + i2);
                        int intValue = num != null ? num.intValue() : -1;
                        Iterator<T> it = ghettoScreen.binding.map.overlayView.get_mapData().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it.next();
                            if (((MapData) obj).getId() == intValue) {
                                break;
                            }
                        }
                        MapData mapData = (MapData) obj;
                        Iterator<T> it2 = ghettoScreen.binding.map.overlayView.get_uniqueData().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            obj2 = it2.next();
                            if (((UniqData) obj2).getId() == intValue) {
                                break;
                            }
                        }
                        UniqData uniqData = (UniqData) obj2;
                        int fraction_id = mapData != null ? mapData.getFraction_id() : 0;
                        ghettoScreen.setFrameMap(new FrameMapData(intValue, fraction_id, ColorsKt.ghettoNames(fraction_id), Integer.valueOf(ColorsKt.ghettoImages(fraction_id)), mapData != null ? Long.valueOf(mapData.getMoney()) : null, mapData != null ? Integer.valueOf(mapData.getRespects()) : null, uniqData != null ? Integer.valueOf(uniqData.getUkrop()) : null, uniqData != null ? Long.valueOf(uniqData.getBalance()) : null, ""));
                    }
                }
            }
        }
        return false;
    }

    private final void setFrameMap(final FrameMapData frameMapData) {
        String string;
        String str;
        GhettoMapFrameBinding ghettoMapFrameBinding = this.binding.frameMap;
        ghettoMapFrameBinding.getRoot().setVisibility(0);
        ghettoMapFrameBinding.title.setText(getTargetActivity().getString(R.string.ghetto_territory_title, new Object[]{Integer.valueOf(frameMapData.getTerritoryId())}));
        String owner = frameMapData.getOwner();
        if (owner == null || owner.length() == 0) {
            ghettoMapFrameBinding.bandCard.setVisibility(8);
            ghettoMapFrameBinding.famName.setText(getTargetActivity().getString(R.string.ghetto_free_territory));
            ghettoMapFrameBinding.logo.setVisibility(8);
        } else {
            ghettoMapFrameBinding.bandCard.setVisibility(0);
            ghettoMapFrameBinding.famName.setText(frameMapData.getOwner());
            int parseColor = Color.parseColor(ColorsKt.ghettoColors(frameMapData.getId()));
            ghettoMapFrameBinding.bandCard.setCardBackgroundColor(ColorUtils.setAlphaComponent(parseColor, 100));
            ghettoMapFrameBinding.famName.setTextColor(parseColor);
            Integer logo = frameMapData.getLogo();
            if (logo != null) {
                logo.intValue();
                ghettoMapFrameBinding.logo.setVisibility(0);
                ghettoMapFrameBinding.logo.setImageResource(frameMapData.getLogo().intValue());
            }
        }
        if (frameMapData.getMoney() == null) {
            ghettoMapFrameBinding.containerBalance.setVisibility(8);
        } else {
            ghettoMapFrameBinding.containerBalance.setVisibility(0);
            ghettoMapFrameBinding.balance.setText(MoneyElementKt.toMoneyFormattedSpannable$default(frameMapData.getMoney().longValue(), false, null, null, null, 15, null));
        }
        if (frameMapData.getResp() == null) {
            ghettoMapFrameBinding.containerRespect.setVisibility(8);
        } else {
            ghettoMapFrameBinding.containerRespect.setVisibility(0);
            ghettoMapFrameBinding.respect.setText(String.valueOf(frameMapData.getResp().intValue()));
        }
        if (frameMapData.getPlant() == null) {
            ghettoMapFrameBinding.containerPlantCount.setVisibility(8);
        } else {
            ghettoMapFrameBinding.containerPlantCount.setVisibility(0);
            ghettoMapFrameBinding.plantCount.setText(String.valueOf(frameMapData.getPlant().intValue()));
        }
        if (frameMapData.getBalance() == null) {
            ghettoMapFrameBinding.containerPlantBalance.setVisibility(8);
        } else {
            ghettoMapFrameBinding.containerPlantBalance.setVisibility(0);
            ghettoMapFrameBinding.plantBalance.setText(MoneyElementKt.toMoneyFormattedSpannable$default(frameMapData.getBalance().longValue(), false, null, null, null, 15, null));
        }
        ghettoMapFrameBinding.buttonEvent.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.ghetto.GhettoScreen$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GhettoScreen.setFrameMap$lambda$0$1(GhettoScreen.this, frameMapData, view);
            }
        });
        TextView textView = ghettoMapFrameBinding.buttonEventText;
        if (this.bandInfo.getRank() < 9) {
            str = getTargetActivity().getString(R.string.ghetto_mark_gps);
        } else {
            if (frameMapData.getId() == this.bandInfo.getId()) {
                string = getTargetActivity().getString(R.string.ghetto_manage_territory);
            } else {
                string = getTargetActivity().getString(R.string.ghetto_plan_battle);
            }
            str = string;
        }
        textView.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setFrameMap$lambda$0$1(GhettoScreen ghettoScreen, FrameMapData frameMapData, View view) {
        SAMPUIElement.notifyClick$default(ghettoScreen, frameMapData.getTerritoryId(), 2, null, 4, null);
    }

    private final void requestTopTerritories() {
        BuildersKt__Builders_commonKt.launch$default(this.client.getScope(), Dispatchers.getMain(), null, new GhettoScreen$requestTopTerritories$1(this, null), 2, null);
    }

    private final void requestCaptures() {
        BuildersKt__Builders_commonKt.launch$default(this.client.getScope(), Dispatchers.getMain(), null, new GhettoScreen$requestCaptures$1(this, null), 2, null);
    }

    private final void requestCapturesCount(int i) {
        BuildersKt__Builders_commonKt.launch$default(this.client.getScope(), Dispatchers.getMain(), null, new GhettoScreen$requestCapturesCount$1(this, i, null), 2, null);
    }

    private final void selectTerritoryItem(FrameMapData frameMapData) {
        setFrameMap(frameMapData);
    }

    private final void navigateTo(Navigation navigation) {
        this.binding.map.getRoot().setVisibility(8);
        this.binding.war.getRoot().setVisibility(8);
        this.binding.frameMap.getRoot().setVisibility(8);
        int i = WhenMappings.$EnumSwitchMapping$0[navigation.ordinal()];
        if (i == 1) {
            this.binding.war.getRoot().setVisibility(0);
            this.binding.topbar.backButton.setVisibility(8);
            requestTopTerritories();
            requestCaptures();
        } else if (i != 2) {
        } else {
            this.binding.map.getRoot().setVisibility(0);
            GhettoTopbarBinding ghettoTopbarBinding = this.binding.topbar;
            ghettoTopbarBinding.backButton.setVisibility(0);
            ghettoTopbarBinding.backButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.ghetto.GhettoScreen$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GhettoScreen.navigateTo$lambda$1$0(GhettoScreen.this, view);
                }
            });
            setMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void navigateTo$lambda$1$0(GhettoScreen ghettoScreen, View view) {
        ghettoScreen.navigateTo(Navigation.War);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: GhettoScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/mrlargha/arizonaui/ghetto/GhettoScreen$Navigation;", "", "<init>", "(Ljava/lang/String;I)V", "Map", "War", "ArizonaUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Navigation {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Navigation[] $VALUES;
        public static final Navigation Map = new Navigation("Map", 0);
        public static final Navigation War = new Navigation("War", 1);

        private static final /* synthetic */ Navigation[] $values() {
            return new Navigation[]{Map, War};
        }

        public static EnumEntries<Navigation> getEntries() {
            return $ENTRIES;
        }

        public static Navigation valueOf(String str) {
            return (Navigation) Enum.valueOf(Navigation.class, str);
        }

        public static Navigation[] values() {
            return (Navigation[]) $VALUES.clone();
        }

        private Navigation(String str, int i) {
        }

        static {
            Navigation[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* compiled from: GhettoScreen.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/arizonaui/ghetto/GhettoScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "ArizonaUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.ARIZONA_GHETTO);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new GhettoScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }
}
