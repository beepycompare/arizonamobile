package com.google.firebase.crashlytics.internal.model;

import com.google.common.base.Ascii;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;
/* loaded from: classes4.dex */
final class AutoValue_CrashlyticsReport_ApplicationExitInfo extends CrashlyticsReport.ApplicationExitInfo {
    private final List<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> buildIdMappingForArch;
    private final int importance;
    private final int pid;
    private final String processName;
    private final long pss;
    private final int reasonCode;
    private final long rss;
    private final long timestamp;
    private final String traceFile;

    private AutoValue_CrashlyticsReport_ApplicationExitInfo(int i, String str, int i2, int i3, long j, long j2, long j3, String str2, List<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> list) {
        this.pid = i;
        this.processName = str;
        this.reasonCode = i2;
        this.importance = i3;
        this.pss = j;
        this.rss = j2;
        this.timestamp = j3;
        this.traceFile = str2;
        this.buildIdMappingForArch = list;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public int getPid() {
        return this.pid;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public String getProcessName() {
        return this.processName;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public int getReasonCode() {
        return this.reasonCode;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public int getImportance() {
        return this.importance;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public long getPss() {
        return this.pss;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public long getRss() {
        return this.rss;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public long getTimestamp() {
        return this.timestamp;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public String getTraceFile() {
        return this.traceFile;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public List<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> getBuildIdMappingForArch() {
        return this.buildIdMappingForArch;
    }

    public String toString() {
        return "ApplicationExitInfo{pid=" + this.pid + ", processName=" + this.processName + ", reasonCode=" + this.reasonCode + ", importance=" + this.importance + ", pss=" + this.pss + ", rss=" + this.rss + ", timestamp=" + this.timestamp + ", traceFile=" + this.traceFile + ", buildIdMappingForArch=" + this.buildIdMappingForArch + "}";
    }

    public boolean equals(Object obj) {
        String str;
        List<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> list;
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.ApplicationExitInfo) {
            CrashlyticsReport.ApplicationExitInfo applicationExitInfo = (CrashlyticsReport.ApplicationExitInfo) obj;
            if (this.pid == applicationExitInfo.getPid() && this.processName.equals(applicationExitInfo.getProcessName()) && this.reasonCode == applicationExitInfo.getReasonCode() && this.importance == applicationExitInfo.getImportance() && this.pss == applicationExitInfo.getPss() && this.rss == applicationExitInfo.getRss() && this.timestamp == applicationExitInfo.getTimestamp() && ((str = this.traceFile) != null ? str.equals(applicationExitInfo.getTraceFile()) : applicationExitInfo.getTraceFile() == null) && ((list = this.buildIdMappingForArch) != null ? list.equals(applicationExitInfo.getBuildIdMappingForArch()) : applicationExitInfo.getBuildIdMappingForArch() == null)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.pss;
        long j2 = this.rss;
        long j3 = this.timestamp;
        int hashCode = (((((((((((((this.pid ^ 1000003) * 1000003) ^ this.processName.hashCode()) * 1000003) ^ this.reasonCode) * 1000003) ^ this.importance) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        String str = this.traceFile;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> list = this.buildIdMappingForArch;
        return hashCode2 ^ (list != null ? list.hashCode() : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class Builder extends CrashlyticsReport.ApplicationExitInfo.Builder {
        private List<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> buildIdMappingForArch;
        private int importance;
        private int pid;
        private String processName;
        private long pss;
        private int reasonCode;
        private long rss;
        private byte set$0;
        private long timestamp;
        private String traceFile;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder setPid(int i) {
            this.pid = i;
            this.set$0 = (byte) (this.set$0 | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder setProcessName(String str) {
            if (str == null) {
                throw new NullPointerException("Null processName");
            }
            this.processName = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder setReasonCode(int i) {
            this.reasonCode = i;
            this.set$0 = (byte) (this.set$0 | 2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder setImportance(int i) {
            this.importance = i;
            this.set$0 = (byte) (this.set$0 | 4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder setPss(long j) {
            this.pss = j;
            this.set$0 = (byte) (this.set$0 | 8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder setRss(long j) {
            this.rss = j;
            this.set$0 = (byte) (this.set$0 | Ascii.DLE);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder setTimestamp(long j) {
            this.timestamp = j;
            this.set$0 = (byte) (this.set$0 | 32);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder setTraceFile(String str) {
            this.traceFile = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder setBuildIdMappingForArch(List<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> list) {
            this.buildIdMappingForArch = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo build() {
            if (this.set$0 != 63 || this.processName == null) {
                StringBuilder sb = new StringBuilder();
                if ((this.set$0 & 1) == 0) {
                    sb.append(" pid");
                }
                if (this.processName == null) {
                    sb.append(" processName");
                }
                if ((this.set$0 & 2) == 0) {
                    sb.append(" reasonCode");
                }
                if ((this.set$0 & 4) == 0) {
                    sb.append(" importance");
                }
                if ((this.set$0 & 8) == 0) {
                    sb.append(" pss");
                }
                if ((this.set$0 & Ascii.DLE) == 0) {
                    sb.append(" rss");
                }
                if ((this.set$0 & 32) == 0) {
                    sb.append(" timestamp");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_CrashlyticsReport_ApplicationExitInfo(this.pid, this.processName, this.reasonCode, this.importance, this.pss, this.rss, this.timestamp, this.traceFile, this.buildIdMappingForArch);
        }
    }
}
