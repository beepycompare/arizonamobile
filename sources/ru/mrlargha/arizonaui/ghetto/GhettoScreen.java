package ru.mrlargha.arizonaui.ghetto;

import android.app.Activity;
import android.content.SharedPreferences;
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
import android.widget.Toast;
import androidx.core.graphics.ColorUtils;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
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
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: GhettoScreen.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0002BCB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016J\u0018\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u0006H\u0016J\b\u0010/\u001a\u00020)H\u0002J\b\u00100\u001a\u00020)H\u0002J\b\u00101\u001a\u00020)H\u0002J\u0010\u00102\u001a\u00020)2\u0006\u0010-\u001a\u00020 H\u0002J\u0016\u00103\u001a\u00020)2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020504H\u0002J\b\u00106\u001a\u00020)H\u0002J\u0010\u00107\u001a\u00020)2\u0006\u0010-\u001a\u000208H\u0002J\b\u00109\u001a\u00020)H\u0002J\b\u0010:\u001a\u00020)H\u0002J\u0010\u0010;\u001a\u00020)2\u0006\u0010<\u001a\u00020\u0006H\u0002J\u0010\u0010=\u001a\u00020)2\u0006\u0010>\u001a\u000208H\u0002J\u0010\u0010?\u001a\u00020)2\u0006\u0010@\u001a\u00020AH\u0002R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u000b*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082.¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lru/mrlargha/arizonaui/ghetto/GhettoScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lru/mrlargha/arizonaui/databinding/GhettoMainBinding;", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sharedPref", "Landroid/content/SharedPreferences;", "serverId", "_token", "", "mapCells", "xMargin", "", "yMargin", "cellWidth", "cellHeight", "warsAdapter", "Lru/mrlargha/arizonaui/ghetto/WarsAdapter;", "bandInfo", "Lru/mrlargha/arizonaui/ghetto/data/BandInfo;", "token", "getToken", "()Ljava/lang/String;", "retrofit", "Lretrofit2/Retrofit;", "api", "Lru/mrlargha/arizonaui/ghetto/GhettoApi;", "setVisible", "", "visible", "", "onBackendMessage", "data", "subId", "initRetrofit", "setupNavigation", "loadMapRetrofit", "setBandInfo", "setUniqCells", "", "Lru/mrlargha/arizonaui/ghetto/data/UniqData;", "setMap", "setFrameMap", "Lru/mrlargha/arizonaui/ghetto/data/FrameMapData;", "requestTopTerritories", "requestCaptures", "requestCapturesCount", "fraction", "selectTerritoryItem", "item", "navigateTo", "nav", "Lru/mrlargha/arizonaui/ghetto/GhettoScreen$Navigation;", "Navigation", "Spawner", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GhettoScreen extends SAMPUIElement implements InterfaceController {
    private final String _token;
    private GhettoApi api;
    private BandInfo bandInfo;
    private final GhettoMainBinding binding;
    private final float cellHeight;
    private final float cellWidth;
    private final CoroutineExceptionHandler handler;
    private final int mapCells;
    private Retrofit retrofit;
    private final CoroutineScope scope;
    private final View screen;
    private final int serverId;
    private final SharedPreferences sharedPref;
    private final WarsAdapter warsAdapter;
    private final float xMargin;
    private final float yMargin;

    /* compiled from: GhettoScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
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
        GhettoScreen$special$$inlined$CoroutineExceptionHandler$1 ghettoScreen$special$$inlined$CoroutineExceptionHandler$1 = new GhettoScreen$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, targetActivity, i);
        this.handler = ghettoScreen$special$$inlined$CoroutineExceptionHandler$1;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob((Job) null)).plus(ghettoScreen$special$$inlined$CoroutineExceptionHandler$1));
        SharedPreferences sharedPreferences = targetActivity.getSharedPreferences("flavorType", 0);
        this.sharedPref = sharedPreferences;
        this.serverId = sharedPreferences.getInt("server_id", 0);
        this._token = sharedPreferences.getString("api_token", "");
        this.mapCells = 10;
        this.xMargin = 187.0f;
        this.yMargin = 150.0f;
        this.cellWidth = 92.0f;
        this.cellHeight = 68.0f;
        WarsAdapter warsAdapter = new WarsAdapter(new Function1() { // from class: ru.mrlargha.arizonaui.ghetto.GhettoScreen$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit warsAdapter$lambda$1;
                warsAdapter$lambda$1 = GhettoScreen.warsAdapter$lambda$1(GhettoScreen.this, ((Integer) obj).intValue());
                return warsAdapter$lambda$1;
            }
        });
        this.warsAdapter = warsAdapter;
        this.bandInfo = new BandInfo(-1, 0, 0, 0);
        Intrinsics.checkNotNullExpressionValue(screen, "screen");
        addViewToConstraintLayout(screen, -1, -1);
        initRetrofit();
        bind.war.menuItemsRv.setAdapter(warsAdapter);
        navigateTo(Navigation.War);
        setupNavigation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit warsAdapter$lambda$1(GhettoScreen ghettoScreen, int i) {
        if (i == 4) {
            ghettoScreen.navigateTo(Navigation.Map);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getToken() {
        return "Bearer " + this._token;
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        this.binding.frameMap.getRoot().setVisibility(8);
        this.binding.getRoot().setVisibility(z ? 0 : 8);
        navigateTo(Navigation.War);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            if (i == 1) {
                setBandInfo((BandInfo) MapperKt.toModel(data, BandInfo.class));
            } else if (i != 2) {
            } else {
                setUniqCells(MapperKt.toListModel(data, UniqData.class));
            }
        } catch (Exception e) {
            Log.d("FAMILY_ARIZONA", data + "  " + e.getMessage());
            e.printStackTrace();
            Toast.makeText(getTargetActivity(), "Ошибка в интерфейсе : " + getBackendID(), 1).show();
        }
    }

    private final void initRetrofit() {
        Retrofit retrofit = null;
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, null);
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Retrofit build = new Retrofit.Builder().baseUrl(FirebaseConfigHelper.INSTANCE.getServerApiUrl() + "client/ghetto/").client(new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()).addConverterFactory(GsonConverterFactory.create()).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        this.retrofit = build;
        if (build == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retrofit");
        } else {
            retrofit = build;
        }
        Object create = retrofit.create(GhettoApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        this.api = (GhettoApi) create;
    }

    private final void setupNavigation() {
        this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.ghetto.GhettoScreen$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GhettoScreen.setupNavigation$lambda$2(GhettoScreen.this, view);
            }
        });
        this.binding.familyOverlay.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.ghetto.GhettoScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GhettoScreen.setupNavigation$lambda$3(GhettoScreen.this, view);
            }
        });
        this.binding.map.button.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.ghetto.GhettoScreen$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GhettoScreen.setupNavigation$lambda$4(GhettoScreen.this, view);
            }
        });
        GhettoTopbarBinding ghettoTopbarBinding = this.binding.topbar;
        ghettoTopbarBinding.closeButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.ghetto.GhettoScreen$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GhettoScreen.setupNavigation$lambda$7$lambda$5(GhettoScreen.this, view);
            }
        });
        ghettoTopbarBinding.backButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.ghetto.GhettoScreen$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GhettoScreen.setupNavigation$lambda$7$lambda$6(GhettoScreen.this, view);
            }
        });
        this.binding.frameMap.buttonClose.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.ghetto.GhettoScreen$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GhettoScreen.setupNavigation$lambda$9$lambda$8(GhettoScreen.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$2(GhettoScreen ghettoScreen, View view) {
        ghettoScreen.binding.frameMap.getRoot().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$3(GhettoScreen ghettoScreen, View view) {
        ghettoScreen.binding.frameMap.getRoot().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$4(GhettoScreen ghettoScreen, View view) {
        SAMPUIElement.notifyClick$default(ghettoScreen, 0, 1, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$7$lambda$5(GhettoScreen ghettoScreen, View view) {
        SAMPUIElement.notifyClick$default(ghettoScreen, 0, 0, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$7$lambda$6(GhettoScreen ghettoScreen, View view) {
        ghettoScreen.navigateTo(Navigation.War);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$9$lambda$8(GhettoScreen ghettoScreen, View view) {
        ghettoScreen.binding.frameMap.getRoot().setVisibility(8);
    }

    private final void loadMapRetrofit() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new GhettoScreen$loadMapRetrofit$1(this, null), 3, null);
    }

    private final void setBandInfo(BandInfo bandInfo) {
        this.bandInfo = bandInfo;
        this.warsAdapter.setInfo(bandInfo);
        requestCapturesCount(bandInfo.getFights_count());
    }

    private final void setUniqCells(List<UniqData> list) {
        Log.d("setDataAndTryToDraw", "FRONTEND: " + list);
        GridOverlayView.setDataAndTryToDraw$default(this.binding.map.overlayView, null, list, 1, null);
    }

    private final void setMap() {
        loadMapRetrofit();
        Bitmap decodeStream = BitmapFactory.decodeStream(getTargetActivity().getResources().openRawResource(R.raw.ghetto_map));
        final SubsamplingScaleImageView subsamplingScaleImageView = this.binding.map.mapView;
        subsamplingScaleImageView.setImage(ImageSource.bitmap(decodeStream));
        float f = 300;
        subsamplingScaleImageView.setScaleAndCenter(2.0f, new PointF(this.xMargin + f, this.yMargin + f));
        subsamplingScaleImageView.setMaxScale(10.0f);
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        final int scaledTouchSlop = ViewConfiguration.get(subsamplingScaleImageView.getContext()).getScaledTouchSlop();
        subsamplingScaleImageView.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.arizonaui.ghetto.GhettoScreen$$ExternalSyntheticLambda7
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean map$lambda$13$lambda$12;
                map$lambda$13$lambda$12 = GhettoScreen.setMap$lambda$13$lambda$12(Ref.FloatRef.this, floatRef2, scaledTouchSlop, subsamplingScaleImageView, this, view, motionEvent);
                return map$lambda$13$lambda$12;
            }
        });
        GridOverlayView gridOverlayView = this.binding.map.overlayView;
        SubsamplingScaleImageView mapView = this.binding.map.mapView;
        Intrinsics.checkNotNullExpressionValue(mapView, "mapView");
        gridOverlayView.setLinkedImageView(mapView, this.mapCells, this.xMargin, this.yMargin, this.cellWidth, this.cellHeight);
        this.binding.map.mapView.setOnStateChangedListener(new SubsamplingScaleImageView.OnStateChangedListener() { // from class: ru.mrlargha.arizonaui.ghetto.GhettoScreen$setMap$2
            @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnStateChangedListener
            public void onScaleChanged(float f2, int i) {
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
    public static final boolean setMap$lambda$13$lambda$12(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, int i, SubsamplingScaleImageView subsamplingScaleImageView, GhettoScreen ghettoScreen, View view, MotionEvent motionEvent) {
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
                        ghettoScreen.setFrameMap(new FrameMapData(intValue, fraction_id, ColorsKt.ghettoNames(fraction_id), Integer.valueOf(ColorsKt.ghettoImages(fraction_id)), mapData != null ? Integer.valueOf(mapData.getMoney()) : null, mapData != null ? Integer.valueOf(mapData.getRespects()) : null, uniqData != null ? Integer.valueOf(uniqData.getUkrop()) : null, uniqData != null ? Integer.valueOf(uniqData.getBalance()) : null, ""));
                    }
                }
            }
        }
        return false;
    }

    private final void setFrameMap(final FrameMapData frameMapData) {
        String str;
        String str2;
        GhettoMapFrameBinding ghettoMapFrameBinding = this.binding.frameMap;
        ghettoMapFrameBinding.getRoot().setVisibility(0);
        ghettoMapFrameBinding.title.setText("Территория №" + frameMapData.getTerritoryId());
        String owner = frameMapData.getOwner();
        if (owner == null || owner.length() == 0) {
            ghettoMapFrameBinding.bandCard.setVisibility(8);
            ghettoMapFrameBinding.famName.setText("Свободная территория");
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
            ghettoMapFrameBinding.balance.setText(frameMapData.getMoney() + " $");
        }
        if (frameMapData.getResp() == null) {
            ghettoMapFrameBinding.containerRespect.setVisibility(8);
        } else {
            ghettoMapFrameBinding.containerRespect.setVisibility(0);
            ghettoMapFrameBinding.respect.setText(String.valueOf(frameMapData.getResp()));
        }
        if (frameMapData.getPlant() == null) {
            ghettoMapFrameBinding.containerPlantCount.setVisibility(8);
        } else {
            ghettoMapFrameBinding.containerPlantCount.setVisibility(0);
            ghettoMapFrameBinding.plantCount.setText(String.valueOf(frameMapData.getPlant()));
        }
        if (frameMapData.getBalance() == null) {
            ghettoMapFrameBinding.containerPlantBalance.setVisibility(8);
        } else {
            ghettoMapFrameBinding.containerPlantBalance.setVisibility(0);
            ghettoMapFrameBinding.plantBalance.setText(String.valueOf(frameMapData.getBalance()));
        }
        ghettoMapFrameBinding.buttonEvent.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.ghetto.GhettoScreen$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GhettoScreen.setFrameMap$lambda$16$lambda$15(GhettoScreen.this, frameMapData, view);
            }
        });
        TextView textView = ghettoMapFrameBinding.buttonEventText;
        if (this.bandInfo.getRank() >= 9) {
            if (frameMapData.getId() == this.bandInfo.getId()) {
                str = "Управление территорией";
            } else {
                str = "Запланировать сражение";
            }
            str2 = str;
        }
        textView.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setFrameMap$lambda$16$lambda$15(GhettoScreen ghettoScreen, FrameMapData frameMapData, View view) {
        SAMPUIElement.notifyClick$default(ghettoScreen, frameMapData.getTerritoryId(), 2, null, 4, null);
    }

    private final void requestTopTerritories() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new GhettoScreen$requestTopTerritories$1(this, null), 3, null);
    }

    private final void requestCaptures() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new GhettoScreen$requestCaptures$1(this, null), 3, null);
    }

    private final void requestCapturesCount(int i) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new GhettoScreen$requestCapturesCount$1(this, i, null), 3, null);
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
                    GhettoScreen.navigateTo$lambda$19$lambda$18(GhettoScreen.this, view);
                }
            });
            setMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void navigateTo$lambda$19$lambda$18(GhettoScreen ghettoScreen, View view) {
        ghettoScreen.navigateTo(Navigation.War);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: GhettoScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/mrlargha/arizonaui/ghetto/GhettoScreen$Navigation;", "", "<init>", "(Ljava/lang/String;I)V", "Map", "War", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
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
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/ghetto/GhettoScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new GhettoScreen(targetActivity, i);
        }
    }
}
