package com.wardrumstudios.utils;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.appstate.AppStateManager;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.example.games.basegameutils.GameHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class WarGameService implements GameHelper.GameHelperListener, ResultCallback<AppStateManager.StateResult>, WarActivityLifecycleListener {
    public static final int CLIENT_ALL = 15;
    public static final int CLIENT_APPSTATE = 4;
    public static final int CLIENT_DRIVE = 8;
    public static final int CLIENT_GAMES = 1;
    public static final int CLIENT_PLUS = 2;
    public static final int RC_SHOWSNAPSHOTLIST = 8321;
    private static final String TAG = "WarGameService";
    private WarBase mActivity;
    protected GameHelper mHelper;
    ArrayList<LeaderboardQuery> queries;
    private boolean isPaused = false;
    protected int mRequestedClients = 1;
    protected String mDebugTag = TAG;
    protected boolean mDebugLog = true;
    protected boolean creatingGamehelper = true;
    byte[] savedScreenshot = null;

    /* loaded from: classes4.dex */
    class LeaderboardQuery {
        int queryId;
        PendingResult<Leaderboards.LoadScoresResult> result;

        LeaderboardQuery() {
        }
    }

    /* loaded from: classes4.dex */
    public class OpenSnapshotResultHandler implements ResultCallback<Snapshots.OpenSnapshotResult> {
        private byte[] data;
        private String description;
        private String name;
        private long playedMS;
        private byte[] screenshot;

        public OpenSnapshotResultHandler(String str, String str2, byte[] bArr, byte[] bArr2, long j) {
            this.name = str;
            this.description = str2;
            this.data = bArr;
            this.screenshot = bArr2;
            this.playedMS = j;
        }

        @Override // com.google.android.gms.common.api.ResultCallback
        public void onResult(Snapshots.OpenSnapshotResult openSnapshotResult) {
            Bitmap bitmap;
            int statusCode = openSnapshotResult.getStatus().getStatusCode();
            if (statusCode != 0) {
                if (statusCode != 4004) {
                    WarGameService.this.debugLog("Failed to save snapshot, status:" + openSnapshotResult.getStatus());
                    return;
                }
                WarGameService.this.debugLog("Conflict while saving, resolving...");
                openSnapshotResult.getSnapshot();
                Games.Snapshots.resolveConflict(WarGameService.this.getApiClient(), openSnapshotResult.getConflictId(), openSnapshotResult.getConflictingSnapshot()).setResultCallback(new OpenSnapshotResultHandler(this.name, this.description, this.data, this.screenshot, this.playedMS));
            } else if (openSnapshotResult.getSnapshot().writeBytes(this.data)) {
                if (this.screenshot != null) {
                    WarGameService.this.debugLog("screenshot " + this.screenshot);
                    WarGameService.this.debugLog("screenshot.length " + this.screenshot.length);
                    byte[] bArr = this.screenshot;
                    bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                    WarGameService.this.debugLog("bitmap " + bitmap);
                } else {
                    bitmap = null;
                }
                SnapshotMetadataChange.Builder builder = new SnapshotMetadataChange.Builder();
                builder.setDescription(this.description);
                long j = this.playedMS;
                if (j > 0) {
                    builder.setPlayedTimeMillis(j);
                }
                if (bitmap != null) {
                    builder.setCoverImage(bitmap);
                }
                Games.Snapshots.commitAndClose(WarGameService.this.getApiClient(), openSnapshotResult.getSnapshot(), builder.build());
            }
        }
    }

    protected WarGameService(WarBase warBase) {
        this.mActivity = warBase;
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.wardrumstudios.utils.WarGameService.1
            @Override // java.lang.Runnable
            public void run() {
                this.mActivity.AddLifecycleListener(this);
                this.mHelper = WarGameService.this.getGameHelper();
                this.setRequestedClients(15);
                this.mHelper.setup(this);
                this.onStart();
                this.creatingGamehelper = false;
            }
        });
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            for (int i = 0; this.creatingGamehelper && i < 10; i++) {
                this.mActivity.mSleep(100L);
            }
        }
    }

    public void CancelLeaderboardQuery(int i) {
        debugLog("CancelLeaderboardQuery");
    }

    public void DeleteAllSnapshots() {
        throw new UnsupportedOperationException();
    }

    public void DeleteSnapshot(String str) {
        debugLog("Deleting snapshot...");
        try {
            Games.Snapshots.open(getApiClient(), str, false).setResultCallback(new ResultCallback<Snapshots.OpenSnapshotResult>() { // from class: com.wardrumstudios.utils.WarGameService.7
                @Override // com.google.android.gms.common.api.ResultCallback
                public void onResult(Snapshots.OpenSnapshotResult openSnapshotResult) {
                    int statusCode = openSnapshotResult.getStatus().getStatusCode();
                    if (statusCode == 0) {
                        Games.Snapshots.delete(WarGameService.this.getApiClient(), openSnapshotResult.getSnapshot().getMetadata()).setResultCallback(new ResultCallback<Snapshots.DeleteSnapshotResult>() { // from class: com.wardrumstudios.utils.WarGameService.7.1
                            @Override // com.google.android.gms.common.api.ResultCallback
                            public void onResult(Snapshots.DeleteSnapshotResult deleteSnapshotResult) {
                                int statusCode2 = deleteSnapshotResult.getStatus().getStatusCode();
                                if (statusCode2 == 0) {
                                    WarGameService.this.debugLog("Successfully deleted snapshot.");
                                } else {
                                    WarGameService.this.debugLog("Error deleting snapshot! status: " + statusCode2);
                                }
                            }
                        });
                    } else if (statusCode != 4000) {
                        WarGameService.this.debugLog("Failed to delete snapshot, status:" + openSnapshotResult.getStatus());
                    } else {
                        WarGameService.this.debugLog("Tried to delete a non-existent snapshot.");
                    }
                }
            });
        } catch (IllegalStateException unused) {
            debugLog("Snapshot ");
        }
    }

    public boolean GetConnectionStatus() {
        return this.mHelper.isSignedIn();
    }

    public String GetPlayerName() {
        String str = "default";
        try {
            if (this.mHelper.isSignedIn()) {
                str = Games.Players.getCurrentPlayer(getApiClient()).getDisplayName();
                System.out.println("GetPlayerName " + str);
                return str;
            }
            return "default";
        } catch (Exception unused) {
            return str;
        }
    }

    public void IncrementAchievement(String str, int i) {
        if (this.mHelper.isSignedIn()) {
            Games.Achievements.increment(getApiClient(), str, i);
        } else {
            debugLog("Trying to unlock an achievement but we're not signed in.");
        }
    }

    public void LoadFromCloud() {
        if (this.mHelper.isSignedIn()) {
            AppStateManager.load(getApiClient(), 0).setResultCallback(this);
        } else {
            debugLog("The GamesClient is not connected so data cannot be saved to the cloud.");
        }
    }

    public void LoadSnapshotCount() {
        Games.Snapshots.load(getApiClient(), false).setResultCallback(new ResultCallback<Snapshots.LoadSnapshotsResult>() { // from class: com.wardrumstudios.utils.WarGameService.5
            @Override // com.google.android.gms.common.api.ResultCallback
            public void onResult(Snapshots.LoadSnapshotsResult loadSnapshotsResult) {
                if (loadSnapshotsResult.getStatus().getStatusCode() != 0) {
                    WarGameService.this.debugLog("Failed to load snapshots, status:" + loadSnapshotsResult.getStatus());
                    return;
                }
                WarGameService.this.notifySnapshotCountLoaded(loadSnapshotsResult.getSnapshots().getCount());
                loadSnapshotsResult.getSnapshots().close();
            }
        });
    }

    public void RefreshData(boolean z) {
    }

    public void ResolveState(String str, byte[] bArr) {
        AppStateManager.resolve(getApiClient(), 0, str, bArr).setResultCallback(this);
    }

    public void SaveScreenshot(byte[] bArr) {
        this.savedScreenshot = bArr;
    }

    public void SaveSnapshot(final String str, final String str2, final byte[] bArr, final long j) {
        debugLog("Saving snapshot...");
        if (!this.isPaused) {
            new Thread(new Runnable() { // from class: com.wardrumstudios.utils.WarGameService.6
                @Override // java.lang.Runnable
                public void run() {
                    while (WarGameService.this.savedScreenshot == null && !str2.contains("InUse save")) {
                        try {
                            Thread.sleep(100L);
                            WarGameService.this.debugLog("SaveSnapshot waiting for screenshot for " + str2);
                        } catch (InterruptedException unused) {
                        }
                    }
                    try {
                        WarGameService.this.debugLog("SaveSnapshot trying to save");
                        PendingResult open = Games.Snapshots.open(WarGameService.this.getApiClient(), str, true);
                        WarGameService warGameService = WarGameService.this;
                        open.setResultCallback(new OpenSnapshotResultHandler(str, str2, bArr, warGameService.savedScreenshot, j));
                        WarGameService.this.savedScreenshot = null;
                    } catch (IllegalStateException unused2) {
                        WarGameService.this.debugLog("Snapshot IllegalStateException");
                    }
                }
            }).start();
            return;
        }
        try {
            Snapshots.OpenSnapshotResult await = Games.Snapshots.open(getApiClient(), str, true).await();
            int statusCode = await.getStatus().getStatusCode();
            if (statusCode != 0) {
                if (statusCode != 4004) {
                    debugLog("Failed to save snapshot, status:" + await.getStatus());
                    return;
                }
                debugLog("Conflict while saving, resolving...");
                await.getSnapshot();
                Games.Snapshots.resolveConflict(getApiClient(), await.getConflictId(), await.getConflictingSnapshot()).await().getStatus().getStatusCode();
                return;
            }
            debugLog("OpenSnapshotResult");
            if (await.getSnapshot().writeBytes(bArr)) {
                SnapshotMetadataChange.Builder builder = new SnapshotMetadataChange.Builder();
                builder.setDescription(str2);
                if (j > 0) {
                    builder.setPlayedTimeMillis(j);
                }
                Games.Snapshots.commitAndClose(getApiClient(), await.getSnapshot(), builder.build());
            }
        } catch (IllegalStateException unused) {
            debugLog("Snapshot IllegalStateException");
        }
    }

    public void SaveToCloud(byte[] bArr) {
        if (this.mHelper.isSignedIn()) {
            AppStateManager.updateImmediate(getApiClient(), 0, bArr).setResultCallback(this);
        } else {
            debugLog("The GamesClient is not connected so data cannot be saved to the cloud.");
        }
    }

    public void ShowAchievementList() {
        if (this.mHelper.isSignedIn()) {
            this.mActivity.startActivityForResult(Games.Achievements.getAchievementsIntent(getApiClient()), 0);
        } else {
            debugLog("The GamesClient is not connected so the achievement list cannot be shown.");
        }
    }

    public void ShowLeaderboard(String str) {
        if (!this.mHelper.isSignedIn()) {
            debugLog("The GamesClient is not connected so the requested leaderboard cannot be shown.");
            return;
        }
        this.mActivity.startActivityForResult(Games.Leaderboards.getLeaderboardIntent(getApiClient(), this.mActivity.GetLeaderboardId(str)), 0);
    }

    public void ShowLeaderboards() {
        if (this.mHelper.isSignedIn()) {
            this.mActivity.startActivityForResult(Games.Leaderboards.getAllLeaderboardsIntent(getApiClient()), 0);
        } else {
            debugLog("The GamesClient is not connected so the leaderboards cannot be shown.");
        }
    }

    public void ShowSignInUI() {
        if (this.mHelper.isSignedIn()) {
            return;
        }
        this.mHelper.beginUserInitiatedSignIn();
    }

    public void ShowSnapshotList() {
        this.mActivity.startActivityForResult(Games.Snapshots.getSelectSnapshotIntent(getApiClient(), "Saved Snapshots", false, true, 10000), RC_SHOWSNAPSHOTLIST);
    }

    public void SignOut() {
        this.mHelper.signOut();
    }

    public void SubmitLeaderboardQuery(String str, int i, int i2, int i3, boolean z, boolean z2) {
        if (!this.mHelper.isSignedIn()) {
            debugLog("The GamesClient is not connected so the requested leaderboard cannot be shown.");
            return;
        }
        String GetLeaderboardId = this.mActivity.GetLeaderboardId(str);
        debugLog("SubmitLeaderboardQuery " + GetLeaderboardId);
        System.out.println("SubmitLeaderboardQuery " + GetLeaderboardId + " friendCollection " + (z ? 1 : 0));
        processPendingResult(i3, Games.Leaderboards.loadTopScores(getApiClient(), GetLeaderboardId, 2, z ? 1 : 0, i, true));
    }

    public void SubmitScore(String str, long j) {
        if (!this.mHelper.isSignedIn()) {
            debugLog("The GamesClient is not connected so the new score cannot be submitted to the leaderboards cannot be shown.");
            return;
        }
        Games.Leaderboards.submitScore(getApiClient(), this.mActivity.GetLeaderboardId(str), j);
    }

    public void UnlockAchievement(String str) {
        String str2;
        debugLog("Unlocking Achievement: " + str);
        if (this.mHelper.isSignedIn()) {
            Games.Achievements.unlock(getApiClient(), str);
            str2 = "Done Unlocking Achievement: " + str;
        } else {
            str2 = "Trying to unlock an achievement while the achievements are not available.";
        }
        debugLog(str2);
    }

    void debugLog(String str) {
        if (this.mDebugLog) {
            Log.d(this.mDebugTag, "WarGameService: " + str);
        }
    }

    protected void enableDebugLog(boolean z, String str) {
        this.mDebugLog = true;
        this.mDebugTag = str;
        GameHelper gameHelper = this.mHelper;
        if (gameHelper != null) {
            gameHelper.enableDebugLog(z);
        }
    }

    protected List<LeaderboardScore> extractScores(Leaderboards.LoadScoresResult loadScoresResult) {
        LeaderboardScoreBuffer scores = loadScoresResult.getScores();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < scores.getCount(); i++) {
            arrayList.add(scores.get(i));
        }
        return arrayList;
    }

    protected GoogleApiClient getApiClient() {
        return this.mHelper.getApiClient();
    }

    public GameHelper getGameHelper() {
        if (this.mHelper == null) {
            GameHelper gameHelper = new GameHelper(this.mActivity, this.mRequestedClients);
            this.mHelper = gameHelper;
            gameHelper.enableDebugLog(this.mDebugLog);
        }
        return this.mHelper;
    }

    protected String getInvitationId() {
        return this.mHelper.getInvitationId();
    }

    public void getPlayerCenteredScores(String str, int i, int i2) {
        Games.Leaderboards.loadPlayerCenteredScores(getApiClient(), str, i, i2, 25, true);
    }

    protected GameHelper.SignInFailureReason getSignInError() {
        return this.mHelper.getSignInError();
    }

    protected boolean hasSignInError() {
        return this.mHelper.hasSignInError();
    }

    protected boolean isSignedIn() {
        return this.mHelper.isSignedIn();
    }

    public native void notifyAchievementsLoaded(String[] strArr, boolean[] zArr, int[] iArr, int[] iArr2);

    public native void notifyLeaderboardScoreQuery(int i, float[] fArr, String[] strArr);

    public void notifyScoresLoaded(int i, List<LeaderboardScore> list) {
        System.out.println("notifyScoresLoaded " + list.size());
        float[] fArr = new float[list.size()];
        String[] strArr = new String[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            fArr[i2] = (float) list.get(i2).getRawScore();
            strArr[i2] = list.get(i2).getScoreHolder().getDisplayName();
            System.out.println("notifyScoresLoaded " + strArr[i2] + " score " + fArr[i2] + " scorestr " + list.get(i2).getDisplayScore());
        }
        notifyLeaderboardScoreQuery(i, fArr, strArr);
    }

    public native void notifySignInChange(boolean z);

    public native void notifySignInFailed();

    public native void notifySnapshotCountLoaded(int i);

    public native void notifySnapshotLoading();

    public native void notifySnapshotSelected(byte[] bArr);

    public native void notifyStateConflict(int i, String str, byte[] bArr, byte[] bArr2);

    public native void notifyStateLoaded(int i, int i2, byte[] bArr);

    @Override // com.wardrumstudios.utils.WarActivityLifecycleListener
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 8321) {
            this.mHelper.onActivityResult(i, i2, intent);
        } else if (i2 != -1) {
        } else {
            notifySnapshotLoading();
            Games.Snapshots.open(getApiClient(), intent.getParcelableExtra("com.google.android.gms.games.SNAPSHOT_METADATA")).setResultCallback(new ResultCallback<Snapshots.OpenSnapshotResult>() { // from class: com.wardrumstudios.utils.WarGameService.2
                @Override // com.google.android.gms.common.api.ResultCallback
                public void onResult(Snapshots.OpenSnapshotResult openSnapshotResult) {
                    int statusCode = openSnapshotResult.getStatus().getStatusCode();
                    if (statusCode == 0) {
                        WarGameService.this.notifySnapshotSelected(openSnapshotResult.getSnapshot().readFully());
                    } else if (statusCode != 4004) {
                        WarGameService.this.notifySnapshotSelected(null);
                        WarGameService.this.debugLog("Failed to open snapshot, status:" + openSnapshotResult.getStatus());
                    } else {
                        WarGameService.this.debugLog("Conflict while opening the selected snapshot, resolving...");
                        Snapshot snapshot = openSnapshotResult.getSnapshot();
                        Snapshot conflictingSnapshot = openSnapshotResult.getConflictingSnapshot();
                        WarGameService.this.debugLog("conflict = " + conflictingSnapshot);
                        WarGameService.this.debugLog("latest = " + snapshot);
                        WarGameService.this.debugLog("conflictId = " + openSnapshotResult.getConflictId());
                        Games.Snapshots.resolveConflict(WarGameService.this.getApiClient(), openSnapshotResult.getConflictId(), conflictingSnapshot).setResultCallback(new ResultCallback<Snapshots.OpenSnapshotResult>() { // from class: com.wardrumstudios.utils.WarGameService.2.1
                            @Override // com.google.android.gms.common.api.ResultCallback
                            public void onResult(Snapshots.OpenSnapshotResult openSnapshotResult2) {
                                if (openSnapshotResult2.getStatus().getStatusCode() != 0) {
                                    WarGameService.this.notifySnapshotSelected(null);
                                    WarGameService.this.debugLog("Failed to save snapshot, status:" + openSnapshotResult2.getStatus());
                                    return;
                                }
                                WarGameService.this.notifySnapshotSelected(openSnapshotResult2.getSnapshot().readFully());
                            }
                        });
                    }
                }
            });
        }
    }

    @Override // com.wardrumstudios.utils.WarActivityLifecycleListener
    public void onDestroy() {
        this.mHelper.onStop();
    }

    public void onLeaderboardMetadataLoaded(int i, LeaderboardBuffer leaderboardBuffer) {
    }

    @Override // com.wardrumstudios.utils.WarActivityLifecycleListener
    public void onPause() {
        this.isPaused = true;
        debugLog("onPause OpenSnapshotResult mActivity.paused " + this.mActivity.paused);
        this.mHelper.onPause();
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public void onResult(AppStateManager.StateResult stateResult) {
        AppStateManager.StateConflictResult conflictResult = stateResult.getConflictResult();
        AppStateManager.StateLoadedResult loadedResult = stateResult.getLoadedResult();
        if (loadedResult != null) {
            notifyStateLoaded(loadedResult.getStatus().getStatusCode(), loadedResult.getStateKey(), loadedResult.getLocalData());
        } else if (conflictResult != null) {
            notifyStateConflict(conflictResult.getStateKey(), conflictResult.getResolvedVersion(), conflictResult.getLocalData(), conflictResult.getServerData());
        }
        if (loadedResult != null) {
            loadedResult.release();
        }
        if (conflictResult != null) {
            conflictResult.release();
        }
    }

    @Override // com.wardrumstudios.utils.WarActivityLifecycleListener
    public void onResume() {
        this.isPaused = false;
    }

    @Override // com.google.example.games.basegameutils.GameHelper.GameHelperListener
    public void onSignInFailed() {
        notifySignInFailed();
    }

    @Override // com.google.example.games.basegameutils.GameHelper.GameHelperListener
    public void onSignInSucceeded() {
        Games.Achievements.load(getApiClient(), false).setResultCallback(new ResultCallback<Achievements.LoadAchievementsResult>() { // from class: com.wardrumstudios.utils.WarGameService.3
            @Override // com.google.android.gms.common.api.ResultCallback
            public void onResult(Achievements.LoadAchievementsResult loadAchievementsResult) {
                int statusCode = loadAchievementsResult.getStatus().getStatusCode();
                AchievementBuffer achievements = loadAchievementsResult.getAchievements();
                WarGameService.this.debugLog("Achivements loaded!");
                if (statusCode != 0) {
                    WarGameService.this.debugLog("Error while loading achievements.");
                    return;
                }
                int count = achievements.getCount();
                String[] strArr = new String[count];
                boolean[] zArr = new boolean[count];
                int[] iArr = new int[count];
                int[] iArr2 = new int[count];
                for (int i = 0; i < count; i++) {
                    strArr[i] = achievements.get(i).getAchievementId();
                    zArr[i] = achievements.get(i).getState() == 0;
                    if (achievements.get(i).getType() == 1) {
                        iArr[i] = achievements.get(i).getCurrentSteps();
                        iArr2[i] = achievements.get(i).getTotalSteps();
                    } else {
                        iArr[i] = -1;
                        iArr2[i] = -1;
                    }
                }
                WarGameService.this.debugLog("Notifying down to native");
                WarGameService.this.notifyAchievementsLoaded(strArr, zArr, iArr, iArr2);
                WarGameService.this.debugLog("Done. Notifying down to native");
                achievements.close();
            }
        });
        notifySignInChange(true);
    }

    @Override // com.wardrumstudios.utils.WarActivityLifecycleListener
    public void onStart() {
        this.mHelper.onStart(this.mActivity);
    }

    @Override // com.wardrumstudios.utils.WarActivityLifecycleListener
    public void onStop() {
        this.mHelper.onStop();
    }

    protected void processPendingResult(final int i, PendingResult<Leaderboards.LoadScoresResult> pendingResult) {
        pendingResult.setResultCallback(new ResultCallback<Leaderboards.LoadScoresResult>() { // from class: com.wardrumstudios.utils.WarGameService.4
            @Override // com.google.android.gms.common.api.ResultCallback
            public void onResult(Leaderboards.LoadScoresResult loadScoresResult) {
                WarGameService.this.notifyScoresLoaded(i, WarGameService.this.extractScores(loadScoresResult));
            }
        });
    }

    protected void setRequestedClients(int i) {
        this.mRequestedClients = i;
    }
}
