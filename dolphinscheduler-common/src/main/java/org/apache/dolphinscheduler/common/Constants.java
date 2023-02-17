/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.dolphinscheduler.common;

import org.apache.dolphinscheduler.common.enums.ExecutionStatus;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;

import java.util.regex.Pattern;

/**
 * Constants
 */
public final class Constants {

    private Constants() {
        throw new UnsupportedOperationException("Construct Constants");
    }

    /**
     * quartz config
     */
    public static final String ORG_QUARTZ_JOBSTORE_DRIVERDELEGATECLASS = "org.quartz.jobStore.driverDelegateClass";
    public static final String ORG_QUARTZ_SCHEDULER_INSTANCENAME = "org.quartz.scheduler.instanceName";
    public static final String ORG_QUARTZ_SCHEDULER_INSTANCEID = "org.quartz.scheduler.instanceId";
    public static final String ORG_QUARTZ_SCHEDULER_MAKESCHEDULERTHREADDAEMON = "org.quartz.scheduler.makeSchedulerThreadDaemon";
    public static final String ORG_QUARTZ_JOBSTORE_USEPROPERTIES = "org.quartz.jobStore.useProperties";
    public static final String ORG_QUARTZ_THREADPOOL_CLASS = "org.quartz.threadPool.class";
    public static final String ORG_QUARTZ_THREADPOOL_THREADCOUNT = "org.quartz.threadPool.threadCount";
    public static final String ORG_QUARTZ_THREADPOOL_MAKETHREADSDAEMONS = "org.quartz.threadPool.makeThreadsDaemons";
    public static final String ORG_QUARTZ_THREADPOOL_THREADPRIORITY = "org.quartz.threadPool.threadPriority";
    public static final String ORG_QUARTZ_JOBSTORE_CLASS = "org.quartz.jobStore.class";
    public static final String ORG_QUARTZ_JOBSTORE_TABLEPREFIX = "org.quartz.jobStore.tablePrefix";
    public static final String ORG_QUARTZ_JOBSTORE_ISCLUSTERED = "org.quartz.jobStore.isClustered";
    public static final String ORG_QUARTZ_JOBSTORE_MISFIRETHRESHOLD = "org.quartz.jobStore.misfireThreshold";
    public static final String ORG_QUARTZ_JOBSTORE_CLUSTERCHECKININTERVAL = "org.quartz.jobStore.clusterCheckinInterval";
    public static final String ORG_QUARTZ_JOBSTORE_ACQUIRETRIGGERSWITHINLOCK = "org.quartz.jobStore.acquireTriggersWithinLock";
    public static final String ORG_QUARTZ_JOBSTORE_DATASOURCE = "org.quartz.jobStore.dataSource";
    public static final String ORG_QUARTZ_DATASOURCE_MYDS_CONNECTIONPROVIDER_CLASS = "org.quartz.dataSource.myDs.connectionProvider.class";
    public static final String ORG_QUARTZ_SCHEDULER_BATCHTRIGGERACQUISTITIONMAXCOUNT = "org.quartz.scheduler.batchTriggerAcquisitionMaxCount";
    /**
     * quartz config default value
     */
    public static final String QUARTZ_TABLE_PREFIX = "QRTZ_";
    public static final String QUARTZ_MISFIRETHRESHOLD = "60000";
    public static final String QUARTZ_CLUSTERCHECKININTERVAL = "5000";
    public static final String QUARTZ_DATASOURCE = "myDs";
    public static final String QUARTZ_THREADCOUNT = "25";
    public static final String QUARTZ_THREADPRIORITY = "5";
    public static final String QUARTZ_INSTANCENAME = "DolphinScheduler";
    public static final String QUARTZ_INSTANCEID = "AUTO";
    public static final String QUARTZ_ACQUIRETRIGGERSWITHINLOCK = "true";
    public static final String QUARTZ_BATCHTRIGGERACQUISTITIONMAXCOUNT = "100";

    /**
     * common properties path
     */
    public static final String COMMON_PROPERTIES_PATH = "/common.properties";

    /**
     * alter properties
     */
    public static final String ALERT_PLUGIN_BINDING = "alert.plugin.binding";
    public static final String ALERT_PLUGIN_DIR = "alert.plugin.dir";
    public static final int ALERT_RPC_PORT = 50052;

    /**
     * registry properties
     */
    public static final String REGISTRY_DOLPHINSCHEDULER_MASTERS = "/nodes/master";
    public static final String REGISTRY_DOLPHINSCHEDULER_WORKERS = "/nodes/worker";
    public static final String REGISTRY_DOLPHINSCHEDULER_DEAD_SERVERS = "/dead-servers";
    public static final String REGISTRY_DOLPHINSCHEDULER_NODE = "/nodes";
    public static final String REGISTRY_DOLPHINSCHEDULER_LOCK_MASTERS = "/lock/masters";
    public static final String REGISTRY_DOLPHINSCHEDULER_LOCK_FAILOVER_MASTERS = "/lock/failover/masters";
    public static final String REGISTRY_DOLPHINSCHEDULER_LOCK_FAILOVER_WORKERS = "/lock/failover/workers";
    public static final String REGISTRY_DOLPHINSCHEDULER_LOCK_FAILOVER_STARTUP_MASTERS = "/lock/failover/startup-masters";
    public static final String REGISTRY_SERVERS = "registry.servers";
    public static final String FOLDER_SEPARATOR = "/";

    /**
     * fs.defaultFS
     */
    public static final String FS_DEFAULTFS = "fs.defaultFS";


    /**
     * fs s3a endpoint
     */
    public static final String FS_S3A_ENDPOINT = "fs.s3a.endpoint";

    /**
     * fs s3a access key
     */
    public static final String FS_S3A_ACCESS_KEY = "fs.s3a.access.key";

    /**
     * fs s3a secret key
     */
    public static final String FS_S3A_SECRET_KEY = "fs.s3a.secret.key";


    /**
     * hadoop configuration
     */
    public static final String HADOOP_RM_STATE_ACTIVE = "ACTIVE";

    public static final String HADOOP_RM_STATE_STANDBY = "STANDBY";

    public static final String HADOOP_RESOURCE_MANAGER_HTTPADDRESS_PORT = "resource.manager.httpaddress.port";

    /**
     * yarn.resourcemanager.ha.rm.ids
     */
    public static final String YARN_RESOURCEMANAGER_HA_RM_IDS = "yarn.resourcemanager.ha.rm.ids";


    /**
     * yarn.application.status.address
     */
    public static final String YARN_APPLICATION_STATUS_ADDRESS = "yarn.application.status.address";

    /**
     * yarn.job.history.status.address
     */
    public static final String YARN_JOB_HISTORY_STATUS_ADDRESS = "yarn.job.history.status.address";

    /**
     * hdfs configuration
     * hdfs.root.user
     */
    public static final String HDFS_ROOT_USER = "hdfs.root.user";

    /**
     * hdfs/s3 configuration
     * resource.upload.path
     */
    public static final String RESOURCE_UPLOAD_PATH = "resource.upload.path";

    /**
     * data basedir path
     */
    public static final String DATA_BASEDIR_PATH = "data.basedir.path";

    /**
     * dolphinscheduler.env.path
     */
    public static final String DOLPHINSCHEDULER_ENV_PATH = "dolphinscheduler.env.path";

    /**
     * environment properties default path
     */
    public static final String ENV_PATH = "env/dolphinscheduler_env.sh";

    /**
     * python home
     */
    public static final String PYTHON_HOME = "PYTHON_HOME";

    /**
     * resource.view.suffixs
     */
    public static final String RESOURCE_VIEW_SUFFIXS = "resource.view.suffixs";

    public static final String RESOURCE_VIEW_SUFFIXS_DEFAULT_VALUE = "txt,log,sh,bat,conf,cfg,py,java,sql,xml,hql,properties,json,yml,yaml,ini,js";

    /**
     * development.state
     */
    public static final String DEVELOPMENT_STATE = "development.state";

    /**
     * sudo enable
     */
    public static final String SUDO_ENABLE = "sudo.enable";

    /**
     * string true
     */
    public static final String STRING_TRUE = "true";

    /**
     * string false
     */
    public static final String STRING_FALSE = "false";

    /**
     * resource storage type
     */
    public static final String RESOURCE_STORAGE_TYPE = "resource.storage.type";

    /**
     * comma ,
     */
    public static final String COMMA = ",";

    /**
     * COLON :
     */
    public static final String COLON = ":";

    /**
     * SPACE " "
     */
    public static final String SPACE = " ";

    /**
     * SINGLE_SLASH /
     */
    public static final String SINGLE_SLASH = "/";

    /**
     * DOUBLE_SLASH //
     */
    public static final String DOUBLE_SLASH = "//";

    /**
     * SINGLE_QUOTES "'"
     */
    public static final String SINGLE_QUOTES = "'";
    /**
     * DOUBLE_QUOTES "\""
     */
    public static final String DOUBLE_QUOTES = "\"";

    /**
     * SEMICOLON ;
     */
    public static final String SEMICOLON = ";";

    /**
     * EQUAL SIGN
     */
    public static final String EQUAL_SIGN = "=";
    /**
     * AT SIGN
     */
    public static final String AT_SIGN = "@";


    /**
     * date format of yyyy-MM-dd HH:mm:ss
     */
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";


    /**
     * date format of yyyyMMddHHmmss
     */
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    /**
     * date format of yyyyMMddHHmmssSSS
     */
    public static final String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
    /**
     * http connect time out
     */
    public static final int HTTP_CONNECT_TIMEOUT = 60 * 1000;


    /**
     * http connect request time out
     */
    public static final int HTTP_CONNECTION_REQUEST_TIMEOUT = 60 * 1000;

    /**
     * httpclient soceket time out
     */
    public static final int SOCKET_TIMEOUT = 60 * 1000;

    /**
     * http header
     */
    public static final String HTTP_HEADER_UNKNOWN = "unKnown";

    /**
     * http X-Forwarded-For
     */
    public static final String HTTP_X_FORWARDED_FOR = "X-Forwarded-For";

    /**
     * http X-Real-IP
     */
    public static final String HTTP_X_REAL_IP = "X-Real-IP";

    /**
     * UTF-8
     */
    public static final String UTF_8 = "UTF-8";

    /**
     * user name regex
     */
    public static final Pattern REGEX_USER_NAME = Pattern.compile("^[a-zA-Z0-9._-]{3,39}$");
    
    /**
     * default display rows
     */
    public static final int DEFAULT_DISPLAY_ROWS = 10;

    /**
     * read permission
     */
    public static final int READ_PERMISSION = 2 * 1;


    /**
     * write permission
     */
    public static final int WRITE_PERMISSION = 2 * 2;


    /**
     * execute permission
     */
    public static final int EXECUTE_PERMISSION = 1;

    /**
     * default admin permission
     */
    public static final int DEFAULT_ADMIN_PERMISSION = 7;

    /**
     * default hash map size
     */
    public static final int DEFAULT_HASH_MAP_SIZE = 16;


    /**
     * all permissions
     */
    public static final int ALL_PERMISSIONS = READ_PERMISSION | WRITE_PERMISSION | EXECUTE_PERMISSION;

    /**
     * max task timeout
     */
    public static final int MAX_TASK_TIMEOUT = 24 * 3600;


    /**
     * master cpu load
     */
    public static final int DEFAULT_MASTER_CPU_LOAD = Runtime.getRuntime().availableProcessors() * 2;

    /**
     * worker cpu load
     */
    public static final int DEFAULT_WORKER_CPU_LOAD = Runtime.getRuntime().availableProcessors() * 2;

    /**
     * worker host weight
     */
    public static final int DEFAULT_WORKER_HOST_WEIGHT = 100;

    /**
     * default log cache rows num,output when reach the number
     */
    public static final int DEFAULT_LOG_ROWS_NUM = 4 * 16;

    /**
     * log flush interval?output when reach the interval
     */
    public static final int DEFAULT_LOG_FLUSH_INTERVAL = 1000;


    /**
     * time unit secong to minutes
     */
    public static final int SEC_2_MINUTES_TIME_UNIT = 60;

    /***
     *
     * rpc port
     */
    public static final int RPC_PORT = 50051;

    /**
     * forbid running task
     */
    public static final String FLOWNODE_RUN_FLAG_FORBIDDEN = "FORBIDDEN";

    /**
     * normal running task
     */
    public static final String FLOWNODE_RUN_FLAG_NORMAL = "NORMAL";

    /**
     * datasource configuration path
     */

    public static final String COMMON_TASK_TYPE = "common";

    public static final String DEFAULT = "default";
    public static final String USER = "user";
    public static final String PASSWORD = "password";
    public static final String XXXXXX = "******";
    public static final String NULL = "NULL";
    public static final String THREAD_NAME_MASTER_SERVER = "Master-Server";
    public static final String THREAD_NAME_WORKER_SERVER = "Worker-Server";

    /**
     * command parameter keys
     */
    public static final String CMD_PARAM_RECOVER_PROCESS_ID_STRING = "ProcessInstanceId";

    public static final String CMD_PARAM_RECOVERY_START_NODE_STRING = "StartNodeIdList";

    public static final String CMD_PARAM_RECOVERY_WAITING_THREAD = "WaitingThreadInstanceId";

    public static final String CMD_PARAM_SUB_PROCESS = "processInstanceId";

    public static final String CMD_PARAM_EMPTY_SUB_PROCESS = "0";

    public static final String CMD_PARAM_SUB_PROCESS_PARENT_INSTANCE_ID = "parentProcessInstanceId";

    public static final String CMD_PARAM_SUB_PROCESS_DEFINE_CODE = "processDefinitionCode";

    public static final String CMD_PARAM_START_NODE_NAMES = "StartNodeNameList";

    public static final String CMD_PARAM_START_NODES = "StartNodeList";

    public static final String CMD_PARAM_START_PARAMS = "StartParams";

    public static final String CMD_PARAM_FATHER_PARAMS = "fatherParams";

    /**
     * complement data start date
     */
    public static final String CMDPARAM_COMPLEMENT_DATA_START_DATE = "complementStartDate";

    /**
     * complement data end date
     */
    public static final String CMDPARAM_COMPLEMENT_DATA_END_DATE = "complementEndDate";

    /**
     * complement date default cron string
     */
    public static final String DEFAULT_CRON_STRING = "0 0 0 * * ? *";

    public static final String SPRING_DATASOURCE_DRIVER_CLASS_NAME = "spring.datasource.driver-class-name";

    public static final String SPRING_DATASOURCE_URL = "spring.datasource.url";

    public static final String SPRING_DATASOURCE_USERNAME = "spring.datasource.username";

    public static final String SPRING_DATASOURCE_PASSWORD = "spring.datasource.password";

    public static final String SPRING_DATASOURCE_CONNECTION_TIMEOUT = "spring.datasource.connectionTimeout";

    public static final String SPRING_DATASOURCE_MIN_IDLE = "spring.datasource.minIdle";

    public static final String SPRING_DATASOURCE_MAX_ACTIVE = "spring.datasource.maxActive";

    public static final String SPRING_DATASOURCE_IDLE_TIMEOUT = "spring.datasource.idleTimeout";

    public static final String SPRING_DATASOURCE_MAX_LIFE_TIME = "spring.datasource.maxLifetime";

    public static final String SPRING_DATASOURCE_VALIDATION_TIMEOUT = "spring.datasource.validationTimeout";

    public static final String SPRING_DATASOURCE_VALIDATION_QUERY = "spring.datasource.validationQuery";

    public static final String SPRING_DATASOURCE_LEAK_DETECTION_THRESHOLD = "spring.datasource.leakDetectionThreshold";

    public static final String SPRING_DATASOURCE_INITIALIZATION_FAIL_TIMEOUT = "spring.datasource.initializationFailTimeout";

    public static final String SPRING_DATASOURCE_IS_AUTOCOMMIT = "spring.datasource.isAutoCommit";

    public static final String SPRING_DATASOURCE_CACHE_PREP_STMTS = "spring.datasource.cachePrepStmts";

    public static final String SPRING_DATASOURCE_PREP_STMT_CACHE_SIZE = "spring.datasource.prepStmtCacheSize";

    public static final String SPRING_DATASOURCE_PREP_STMT_CACHE_SQL_LIMIT = "spring.datasource.prepStmtCacheSqlLimit";

    public static final String CACHE_PREP_STMTS = "cachePrepStmts";

    public static final String PREP_STMT_CACHE_SIZE = "prepStmtCacheSize";

    public static final String PREP_STMT_CACHE_SQL_LIMIT = "prepStmtCacheSqlLimit";

    public static final String QUARTZ_PROPERTIES_PATH = "quartz.properties";

    /**
     * sleep time
     */
    public static final int SLEEP_TIME_MILLIS = 1000;

    /**
     * one second mils
     */
    public static final int SECOND_TIME_MILLIS = 1000;

    /**
     * master task instance cache-database refresh interval
     */
    public static final int CACHE_REFRESH_TIME_MILLIS = 20 * 1000;

    /**
     * heartbeat for zk info length
     */
    public static final int HEARTBEAT_FOR_ZOOKEEPER_INFO_LENGTH = 14;

    /**
     * jar
     */
    public static final String JAR = "jar";

    /**
     * hadoop
     */
    public static final String HADOOP = "hadoop";

    /**
     * -D <property>=<value>
     */
    public static final String D = "-D";

    /**
     * -D mapreduce.job.name=name
     */
    public static final String MR_NAME = "mapreduce.job.name";

    /**
     * -D mapreduce.job.queuename=queuename
     */
    public static final String MR_QUEUE = "mapreduce.job.queuename";


    /**
     * spark params constant
     */
    public static final String MASTER = "--master";

    public static final String DEPLOY_MODE = "--deploy-mode";

    /**
     * --class CLASS_NAME
     */
    public static final String MAIN_CLASS = "--class";

    /**
     * --driver-cores NUM
     */
    public static final String DRIVER_CORES = "--driver-cores";

    /**
     * --driver-memory MEM
     */
    public static final String DRIVER_MEMORY = "--driver-memory";

    /**
     * --num-executors NUM
     */
    public static final String NUM_EXECUTORS = "--num-executors";

    /**
     * --executor-cores NUM
     */
    public static final String EXECUTOR_CORES = "--executor-cores";

    /**
     * --executor-memory MEM
     */
    public static final String EXECUTOR_MEMORY = "--executor-memory";

    /**
     * --name NAME
     */
    public static final String SPARK_NAME = "--name";

    /**
     * --queue QUEUE
     */
    public static final String SPARK_QUEUE = "--queue";


    /**
     * exit code success
     */
    public static final int EXIT_CODE_SUCCESS = 0;

    /**
     * exit code kill
     */
    public static final int EXIT_CODE_KILL = 137;

    /**
     * exit code failure
     */
    public static final int EXIT_CODE_FAILURE = -1;

    /**
     * process or task definition failure
     */
    public static final int DEFINITION_FAILURE = -1;

    /**
     * process or task definition first version
     */
    public static final int VERSION_FIRST  = 1;

    /**
     * date format of yyyyMMdd
     */
    public static final String PARAMETER_FORMAT_DATE = "yyyyMMdd";

    /**
     * date format of yyyyMMddHHmmss
     */
    public static final String PARAMETER_FORMAT_TIME = "yyyyMMddHHmmss";

    /**
     * system date(yyyyMMddHHmmss)
     */
    public static final String PARAMETER_DATETIME = "system.datetime";

    /**
     * system date(yyyymmdd) today
     */
    public static final String PARAMETER_CURRENT_DATE = "system.biz.curdate";

    /**
     * system date(yyyymmdd) yesterday
     */
    public static final String PARAMETER_BUSINESS_DATE = "system.biz.date";

    /**
     * the absolute path of current executing task
     */
    public static final String PARAMETER_TASK_EXECUTE_PATH = "system.task.execute.path";

    /**
     * the instance id of current task
     */
    public static final String PARAMETER_TASK_INSTANCE_ID = "system.task.instance.id";

    /**
     * ACCEPTED
     */
    public static final String ACCEPTED = "ACCEPTED";

    /**
     * SUCCEEDED
     */
    public static final String SUCCEEDED = "SUCCEEDED";
    /**
     * ENDED
     */
    public static final String ENDED = "ENDED";
    /**
     * NEW
     */
    public static final String NEW = "NEW";
    /**
     * NEW_SAVING
     */
    public static final String NEW_SAVING = "NEW_SAVING";
    /**
     * SUBMITTED
     */
    public static final String SUBMITTED = "SUBMITTED";
    /**
     * FAILED
     */
    public static final String FAILED = "FAILED";
    /**
     * KILLED
     */
    public static final String KILLED = "KILLED";
    /**
     * RUNNING
     */
    public static final String RUNNING = "RUNNING";
    /**
     * underline  "_"
     */
    public static final String UNDERLINE = "_";
    /**
     * quartz job prifix
     */
    public static final String QUARTZ_JOB_PRIFIX = "job";
    /**
     * quartz job group prifix
     */
    public static final String QUARTZ_JOB_GROUP_PRIFIX = "jobgroup";
    /**
     * projectId
     */
    public static final String PROJECT_ID = "projectId";
    /**
     * processId
     */
    public static final String SCHEDULE_ID = "scheduleId";
    /**
     * schedule
     */
    public static final String SCHEDULE = "schedule";
    /**
     * application regex
     */
    public static final String APPLICATION_REGEX = "application_\\d+_\\d+";
    public static final String PID = SystemUtils.IS_OS_WINDOWS ? "handle" : "pid";
    /**
     * month_begin
     */
    public static final String MONTH_BEGIN = "month_begin";
    /**
     * add_months
     */
    public static final String ADD_MONTHS = "add_months";
    /**
     * month_end
     */
    public static final String MONTH_END = "month_end";
    /**
     * week_begin
     */
    public static final String WEEK_BEGIN = "week_begin";
    /**
     * week_end
     */
    public static final String WEEK_END = "week_end";
    /**
     * timestamp
     */
    public static final String TIMESTAMP = "timestamp";
    public static final char SUBTRACT_CHAR = '-';
    public static final char ADD_CHAR = '+';
    public static final char MULTIPLY_CHAR = '*';
    public static final char DIVISION_CHAR = '/';
    public static final char LEFT_BRACE_CHAR = '(';
    public static final char RIGHT_BRACE_CHAR = ')';
    public static final String ADD_STRING = "+";
    public static final String STAR = "*";
    public static final String DIVISION_STRING = "/";
    public static final String LEFT_BRACE_STRING = "(";
    public static final char P = 'P';
    public static final char N = 'N';
    public static final String SUBTRACT_STRING = "-";
    public static final String GLOBAL_PARAMS = "globalParams";
    public static final String LOCAL_PARAMS = "localParams";
    public static final String LOCAL_PARAMS_LIST = "localParamsList";
    public static final String SUBPROCESS_INSTANCE_ID = "subProcessInstanceId";
    public static final String PROCESS_INSTANCE_STATE = "processInstanceState";
    public static final String PARENT_WORKFLOW_INSTANCE = "parentWorkflowInstance";
    public static final String CONDITION_RESULT = "conditionResult";
    public static final String SWITCH_RESULT = "switchResult";
    public static final String WAIT_START_TIMEOUT = "waitStartTimeout";
    public static final String DEPENDENCE = "dependence";
    public static final String TASK_TYPE = "taskType";
    public static final String TASK_LIST = "taskList";
    public static final String WARNING_GROUP_NAME="warningGroupName";
    public static final String RWXR_XR_X = "rwxr-xr-x";
    public static final String QUEUE = "queue";
    public static final String QUEUE_NAME = "queueName";
    public static final int LOG_QUERY_SKIP_LINE_NUMBER = 0;
    public static final int LOG_QUERY_LIMIT = 4096;

    /**
     * master/worker server use for zk
     */
    public static final String MASTER_TYPE = "master";
    public static final String WORKER_TYPE = "worker";
    public static final String DELETE_OP = "delete";
    public static final String ADD_OP = "add";
    public static final String ALIAS = "alias";
    public static final String CONTENT = "content";
    public static final String DEPENDENT_SPLIT = ":||";
    public static final String DEPENDENT_ALL = "ALL";
    public static final long DEPENDENT_ALL_TASK_CODE = 0;



    /**
     * preview schedule execute count
     */
    public static final int PREVIEW_SCHEDULE_EXECUTE_COUNT = 5;

    /**
     * kerberos
     */
    public static final String KERBEROS = "kerberos";

    /**
     * kerberos expire time
     */
    public static final String KERBEROS_EXPIRE_TIME = "kerberos.expire.time";

    /**
     * java.security.krb5.conf
     */
    public static final String JAVA_SECURITY_KRB5_CONF = "java.security.krb5.conf";

    /**
     * java.security.krb5.conf.path
     */
    public static final String JAVA_SECURITY_KRB5_CONF_PATH = "java.security.krb5.conf.path";

    /**
     * hadoop.security.authentication
     */
    public static final String HADOOP_SECURITY_AUTHENTICATION = "hadoop.security.authentication";

    /**
     * hadoop.security.authentication
     */
    public static final String HADOOP_SECURITY_AUTHENTICATION_STARTUP_STATE = "hadoop.security.authentication.startup.state";

    /**
     * com.amazonaws.services.s3.enableV4
     */
    public static final String AWS_S3_V4 = "com.amazonaws.services.s3.enableV4";

    /**
     * loginUserFromKeytab user
     */
    public static final String LOGIN_USER_KEY_TAB_USERNAME = "login.user.keytab.username";

    /**
     * loginUserFromKeytab path
     */
    public static final String LOGIN_USER_KEY_TAB_PATH = "login.user.keytab.path";

    /**
     * task log info format
     */
    public static final String TASK_LOG_INFO_FORMAT = "TaskLogInfo-%s";

    /**
     * hive conf
     */
    public static final String HIVE_CONF = "hiveconf:";

    /**
     * flink
     */
    public static final String FLINK_YARN_CLUSTER = "yarn-cluster";
    public static final String FLINK_RUN_MODE = "-m";
    public static final String FLINK_YARN_SLOT = "-ys";
    public static final String FLINK_APP_NAME = "-ynm";
    public static final String FLINK_QUEUE = "-yqu";
    public static final String FLINK_TASK_MANAGE = "-yn";

    public static final String FLINK_JOB_MANAGE_MEM = "-yjm";
    public static final String FLINK_TASK_MANAGE_MEM = "-ytm";
    public static final String FLINK_MAIN_CLASS = "-c";
    public static final String FLINK_PARALLELISM = "-p";
    public static final String FLINK_SHUTDOWN_ON_ATTACHED_EXIT = "-sae";


    public static final int[] NOT_TERMINATED_STATES = new int[] {
        ExecutionStatus.SUBMITTED_SUCCESS.ordinal(),
        ExecutionStatus.RUNNING_EXECUTION.ordinal(),
        ExecutionStatus.DELAY_EXECUTION.ordinal(),
        ExecutionStatus.READY_PAUSE.ordinal(),
        ExecutionStatus.READY_STOP.ordinal(),
        ExecutionStatus.NEED_FAULT_TOLERANCE.ordinal(),
        ExecutionStatus.WAITING_THREAD.ordinal(),
        ExecutionStatus.WAITING_DEPEND.ordinal()
    };

    /**
     * status
     */
    public static final String STATUS = "status";

    /**
     * message
     */
    public static final String MSG = "msg";

    /**
     * data total
     */
    public static final String COUNT = "count";

    /**
     * page size
     */
    public static final String PAGE_SIZE = "pageSize";

    /**
     * current page no
     */
    public static final String PAGE_NUMBER = "pageNo";


    /**
     *
     */
    public static final String DATA_LIST = "data";

    public static final String TOTAL_LIST = "totalList";

    public static final String CURRENT_PAGE = "currentPage";

    public static final String TOTAL_PAGE = "totalPage";

    public static final String TOTAL = "total";

    /**
     * workflow
     */
    public static final String WORKFLOW_LIST = "workFlowList";
    public static final String WORKFLOW_RELATION_LIST = "workFlowRelationList";

    /**
     * session user
     */
    public static final String SESSION_USER = "session.user";

    public static final String SESSION_ID = "sessionId";

    public static final String PASSWORD_DEFAULT = "******";

    /**
     * locale
     */
    public static final String LOCALE_LANGUAGE = "language";

    /**
     * driver
     */
    public static final String ORG_POSTGRESQL_DRIVER = "org.postgresql.Driver";
    public static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String ORG_APACHE_HIVE_JDBC_HIVE_DRIVER = "org.apache.hive.jdbc.HiveDriver";
    public static final String COM_CLICKHOUSE_JDBC_DRIVER = "ru.yandex.clickhouse.ClickHouseDriver";
    public static final String COM_ORACLE_JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String COM_SQLSERVER_JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String COM_DB2_JDBC_DRIVER = "com.ibm.db2.jcc.DB2Driver";
    public static final String COM_PRESTO_JDBC_DRIVER = "com.facebook.presto.jdbc.PrestoDriver";


    /**
     * validation Query
     */
    public static final String POSTGRESQL_VALIDATION_QUERY = "select version()";
    public static final String MYSQL_VALIDATION_QUERY = "select 1";
    public static final String HIVE_VALIDATION_QUERY = "select 1";
    public static final String CLICKHOUSE_VALIDATION_QUERY = "select 1";
    public static final String ORACLE_VALIDATION_QUERY = "select 1 from dual";
    public static final String SQLSERVER_VALIDATION_QUERY = "select 1";
    public static final String DB2_VALIDATION_QUERY = "select 1 from sysibm.sysdummy1";
    public static final String PRESTO_VALIDATION_QUERY = "select 1";

    /**
     * database type
     */
    public static final String MYSQL = "MYSQL";
    public static final String POSTGRESQL = "POSTGRESQL";
    public static final String HIVE = "HIVE";
    public static final String SPARK = "SPARK";
    public static final String CLICKHOUSE = "CLICKHOUSE";
    public static final String ORACLE = "ORACLE";
    public static final String SQLSERVER = "SQLSERVER";
    public static final String DB2 = "DB2";
    public static final String PRESTO = "PRESTO";

    /**
     * jdbc url
     */
    public static final String JDBC_MYSQL = "jdbc:mysql://";
    public static final String JDBC_POSTGRESQL = "jdbc:postgresql://";
    public static final String JDBC_HIVE_2 = "jdbc:hive2://";
    public static final String JDBC_CLICKHOUSE = "jdbc:clickhouse://";
    public static final String JDBC_ORACLE_SID = "jdbc:oracle:thin:@";
    public static final String JDBC_ORACLE_SERVICE_NAME = "jdbc:oracle:thin:@//";
    public static final String JDBC_SQLSERVER = "jdbc:sqlserver://";
    public static final String JDBC_DB2 = "jdbc:db2://";
    public static final String JDBC_PRESTO = "jdbc:presto://";


    public static final String ADDRESS = "address";
    public static final String DATABASE = "database";
    public static final String JDBC_URL = "jdbcUrl";
    public static final String PRINCIPAL = "principal";
    public static final String OTHER = "other";
    public static final String ORACLE_DB_CONNECT_TYPE = "connectType";
    public static final String KERBEROS_KRB5_CONF_PATH = "javaSecurityKrb5Conf";
    public static final String KERBEROS_KEY_TAB_USERNAME = "loginUserKeytabUsername";
    public static final String KERBEROS_KEY_TAB_PATH = "loginUserKeytabPath";

    /**
     * session timeout
     */
    public static final int SESSION_TIME_OUT = 7200;
    public static final int MAX_FILE_SIZE = 1024 * 1024 * 1024;
    public static final String UDF = "UDF";
    public static final String CLASS = "class";
    public static final String RECEIVERS = "receivers";
    public static final String RECEIVERS_CC = "receiversCc";


    /**
     * dataSource sensitive param
     */
    public static final String DATASOURCE_PASSWORD_REGEX = "(?<=((?i)password((\\\\\":\\\\\")|(=')))).*?(?=((\\\\\")|(')))";

    /**
     * default worker group
     */
    public static final String DEFAULT_WORKER_GROUP = "default";

    public static final Integer TASK_INFO_LENGTH = 5;

    /**
     * new
     * schedule time
     */
    public static final String PARAMETER_SHECDULE_TIME = "schedule.time";
    /**
     * authorize writable perm
     */
    public static final int AUTHORIZE_WRITABLE_PERM = 7;
    /**
     * authorize readable perm
     */
    public static final int AUTHORIZE_READABLE_PERM = 4;

    public static final int NORMAL_NODE_STATUS = 0;
    public static final int ABNORMAL_NODE_STATUS = 1;
    public static final int BUSY_NODE_STATUE = 2;

    public static final String START_TIME = "start time";
    public static final String END_TIME = "end time";
    public static final String START_END_DATE = "startDate,endDate";

    /**
     * system line separator
     */
    public static final String SYSTEM_LINE_SEPARATOR = System.getProperty("line.separator");

    /**
     * datasource encryption salt
     */
    public static final String DATASOURCE_ENCRYPTION_SALT_DEFAULT = "!@#$%^&*";
    public static final String DATASOURCE_ENCRYPTION_ENABLE = "datasource.encryption.enable";
    public static final String DATASOURCE_ENCRYPTION_SALT = "datasource.encryption.salt";

    /**
     * network interface preferred
     */
    public static final String DOLPHIN_SCHEDULER_NETWORK_INTERFACE_PREFERRED = "dolphin.scheduler.network.interface.preferred";

    /**
     * network IP gets priority, default inner outer
     */
    public static final String DOLPHIN_SCHEDULER_NETWORK_PRIORITY_STRATEGY = "dolphin.scheduler.network.priority.strategy";

    /**
     * exec shell scripts
     */
    public static final String SH = "sh";

    /**
     * pstree, get pud and sub pid
     */
    public static final String PSTREE = "pstree";

    /**
     * snow flake, data center id, this id must be greater than 0 and less than 32
     */
    public static final String SNOW_FLAKE_DATA_CENTER_ID = "data.center.id";

    /**
     * docker & kubernetes
     */
    public static final boolean DOCKER_MODE = !StringUtils.isEmpty(System.getenv("DOCKER"));
    public static final Boolean KUBERNETES_MODE = !StringUtils.isEmpty(System.getenv("KUBERNETES_SERVICE_HOST")) && !StringUtils.isEmpty(System.getenv("KUBERNETES_SERVICE_PORT"));

    /**
     * dry run flag
     */
    public static final int DRY_RUN_FLAG_NO = 0;
    public static final int DRY_RUN_FLAG_YES = 1;

    public static final String CACHE_KEY_VALUE_ALL = "'all'";


    /**
     * NewLand Custom variables
     */
    public static final String  PRE_MON_YEAR_NUMBER = "pre_mon_year_number";// 上月月份
    public static final String  DATA_SEC_END = "data_sec_end";// 数据时间-秒
    public static final String  DATA_SEC = "data_sec";// 数据时间-秒(不足补0)
    public static final String  DATA_MIN_END = "data_min_end";// 数据时间-分
    public static final String  DATA_MIN = "data_min";// 数据时间-分(不足补0)
    public static final String  DATA_HOUR_END = "data_hour_end";// 数据时间-时
    public static final String  DATA_HOUR = "data_hour";// 数据时间-时(不足补0)
    public static final String  DATA_DAY_END = "data_day_end";// 数据时间-日
    public static final String  DATA_DAY = "data_day";// 数据时间-日(不足补0)
    public static final String  DATA_MONTH_END = "data_month_end";// 数据时间-月
    public static final String  DATA_MONTH = "data_month";// 数据时间-月(不足补0)
    public static final String  DATA_YEAR_END = "data_year_end";// 数据时间-年(最后两位)
    public static final String  DATA_YEAR = "data_year";// 数据时间-年
    public static final String  RUN_DATE = "run_date";// 年月日
    public static final String  RUN_TIME = "run_time";// 年月日时分秒
    public static final String  CURRENT_TIME_MILLIS = "current_time_millis";// 当前毫秒时间
    public static final String  REDO_CNT = "redo_cnt";// 任务运行次数(从0计数)
    public static final String  REDO_CNT_PLUS_1 = "redo_cnt_plus_1";// 任务运行次数(从1计数)
    public static final String  DAY_NUMBER_CC = "day_number_cc";// 日，最前面补0  DD
    public static final String  STAT_DATE = "stat_date";// 日期YYYYMMDD
    public static final String  NEXT_DATE = "next_date";// 下一天YYYYMMDD
    public static final String  NEXT_DAY_NUMBER = "next_day_number";// 下一天_day_number DD
    public static final String  NEXT_2_DATE = "next_2_date";// 下2天 YYYYMMDD
    public static final String  DOUBLE_YEAR = "double_year";// 奇偶年
    public static final String  DOUBLE_MONTH = "double_month";// 奇偶月，最前面补0
    public static final String  DOUBLE_MONTH_D = "double_month_d";// 奇偶月
    public static final String  PARTITIONKEY_DAY_3 = "partitionkey_day_3";// 日3分区
    public static final String  PARTITIONKEY_DAY_400 = "partitionkey_day_400";// 日400分区
    public static final String  PARTITIONKEY_DAY_400_CC = "partitionkey_day_400_cc";// 日400分区，最前面补0
    public static final String  PARTITIONKEY_DAY_36_CC = "partitionkey_day_36_cc";// 日36分区，最前面补0
    public static final String  NEXT_PARTITIONKEY_DAY_36 = "next_partitionkey_day_36";// 下一天日36分区
    public static final String  NEXT_PARTITIONKEY_DAY_36_CC = "next_partitionkey_day_36_cc";// 下一天日36分区，最前面补0
    public static final String  PARTITIONKEY_DAY_90 = "partitionkey_day_90";// 日90分区
    public static final String  PARTITIONKEY_DAY_90_CC = "partitionkey_day_90_cc";// 日90分区，最前面补0
    public static final String  WEEK_NUM = "week_num";// 日星期几
    public static final String  LAST_DATE = "last_date";// 本月最后一天
    public static final String  LAST_DAY_NUMBER = "last_day_number";// 本月天数
    public static final String  PER_LAST_DATE = "per_last_date";// 上月最后一天
    public static final String  PRE_LAST_DAY_NUMBER = "pre_last_day_number";// 上月天数
    public static final String  MON_NUMBER12 = "mon_number12";// 12月
    public static final String  MON_NUMBER12_CC = "mon_number12_cc";// 12月，最前面补0
    public static final String  NEXT_MON_NUMBER12 = "next_mon_number12";// 下一天12月
    public static final String  NEXT_MON_NUMBER12_CC = "next_mon_number12_cc";// 下一天12月，最前面补0
    public static final String  PRE_MON_NUMBER12 = "pre_mon_number12";// 上月的月份
    public static final String  PRE_MON_NUMBER12_CC = "pre_mon_number12_cc";// 上月的月份，最前面补0
    public static final String  PRE_MON_DOUBLE_YEAR = "pre_mon_double_year";// 上月的奇偶年
    public static final String  PARTITIONKEY_MON_7 = "partitionkey_mon_7";// 月7分区
    public static final String  PARTITIONKEY_MON_25_PRE = "partitionkey_mon_25_pre";// 上月25分区
    public static final String  PARTITIONKEY_MON_25_CC_PRE = "partitionkey_mon_25_cc_pre";// 上月25分区，最前面补0
    public static final String  PRE_DAY_NUMBER = "pre_day_number";// 上一天day_number
    public static final String  PRE_DATE = "pre_date";// 上一天日期
    public static final String  PRE_DOUBLE_MONTH = "pre_double_month";// 前一天的奇偶月，最前面补0
    public static final String  PRE_DOUBLE_MONTH_D = "pre_double_month_d";// 前一天的奇偶月
    public static final String  PARTITIONKEY_MON_3 = "partitionkey_mon_3";// 月3分区
    public static final String  THREE_MONTH = "three_month";// 3月,格式01/02/03(1月为01)
    public static final String  PRE_DOUBLE_YEAR = "pre_double_year";// 上月的奇偶年
    public static final String  STAT_MONTH = "stat_month";// 月份
    public static final String  PARTITIONKEY_MON_25 = "partitionkey_mon_25";// 月25分区
    public static final String  PARTITIONKEY_MON_25_CC = "partitionkey_mon_25_cc";// 月25分区，最前面补0
    public static final String  FIVE_YEAR = "five_year";// 5年,,格式01/02/03/04/05
    public static final String  PRE_DAY_INMONTH = "pre_day_inmonth";// 本月中前一天日期
    public static final String  V_FIVE_YEAR_PREY = "v_five_year_preY";// 上一年五年分表，格式01/02/03/04/05
    public static final String  V_PARTITION_KEY_60_CC = "v_partition_key_60_cc";// 月变量60个月分区补0
    public static final String  V_PARTITION_KEY_60_PRE1_CC = "v_partition_key_60_pre1_cc";// 上个月60分区cc
    public static final String  V_LAST_YEAR_FIVE = "v_last_year_five";// 日：上月上一年五年分区
    public static final String  V_FIVE_YEAR_PRE3 = "v_five_year_pre3";// 三个月前五年分区/月变量：上3个月对应的五年分区
    public static final String  V_PRE_DAY400_DATE = "v_pre_day400_date";// 日变量，统计日期四百天之前的日期
    public static final String  V_PRE_MON60_MON = "v_pre_mon60_mon";// 月变量，取统计月份五年前的月份
    public static final String  V_PRE_YEAR_DAY = "v_pre_year_day";// 日变量 取去年同期（日）
    public static final String  V_PRE_YEAR_MON = "v_pre_year_mon";// 月变量 取去年同期（月）
    public static final String  PRE2_MON_YEAR_NUMBER = "pre2_mon_year_number";// 上上个月
    public static final String  PRE1_MON_YEAR_NUMBER = "pre1_mon_year_number";// 上一个月,YYYYMM
    public static final String  PRE_THREE_MONTH = "pre_three_month";// 上个月，三月分区
    public static final String  PARTITIONKEY_MON_120_CC = "partitionkey_mon_120_cc";// 月120分区,最前面补0
    public static final String  PARTITIONKEY_MON_120 = "partitionkey_mon_120";// 月120分区
    public static final String  PRE_DAY_400 = "pre_day_400";// 日：上一日400分区
    public static final String  V_LAST_YEAR = "v_last_year";// 日对应上一年
    public static final String  V_PARTITION_KEY_60 = "v_partition_key_60";// 月变量60个月分区
    public static final String  V_PARTITION_KEY_60_PRE1 = "v_partition_key_60_pre1";// 月变量 上一个月对应的60分区
    public static final String  V_FIVE_YEAR_PRE1 = "v_five_year_pre1";// 月上一月对应5年分区
    public static final String  V_FIVE_YEAR_PRE2 = "v_five_year_pre2";// 月上两月对应5年分区
    public static final String  V_NEXT_MONTH = "v_next_month";// 月下月
    public static final String  V_FIVE_YEAR_NEXT1 = "v_five_year_next1";// 月：下月五年分区
    public static final String  V_FIVE_YEAR_PREY2 = "v_five_year_preY2";// 年：前年对应的五年分区
    public static final String  NEXT1_MON_NUMBER12_CC = "next1_mon_number12_cc";// 月：下月MM
    public static final String  NEXT2_MON_NUMBER12_CC = "next2_mon_number12_cc";// 月：下下月MM
    public static final String  NEXT1_MON_YEAR_NUMBER = "next1_mon_year_number";// 月：下月YYYYMM
    public static final String  NEXT2_MON_YEAR_NUMBER = "next2_mon_year_number";// 月：下下月YYYYMM
    public static final String  PRE_DAY_THREE_MONTH = "pre_day_three_month";// 上一天所在月对应的3分区，取2位
    public static final String  PRE_DAY_MON_NUMBER12 = "pre_day_mon_number12";// 当前日前一天对应的月，取数字
    public static final String  PARTITIONKEY_DAY_40_CC = "partitionkey_day_40_cc";// 日变量:40分区
    public static final String  PRE_THREE_MONTH_7 = "pre_three_month_7";// 日变量：当前日对应的上一周三月分区
    public static final String  PARTITIONKEY_DAY_400_7 = "partitionkey_day_400_7";// 日变量：当前日对应的上一周400分区
    public static final String  PARTITIONKEY_MONTH_400 = "partitionkey_month_400";// 日变量：当前日对应的上一月同期400分区
    public static final String  V_PARTITION_KEY_60_PRE12 = "v_partition_key_60_pre12";// 月变量：当前月对应的上一年同期的60分区
    public static final String  V_PARTITION_KEY_60_PRE2 = "v_partition_key_60_pre2";// 月变量：上上月对应的60分区
    public static final String  PRE_YEAR_PARTITION_KEY_60_MON = "pre_year_partition_key_60_mon";// 月变量：上一年最后一个月对应的60分区
    public static final String  PRE1_MON_YEAR_NUMBER12 = "pre1_mon_year_number12";// 月变量：上一年最后一个月
    public static final String  PRE_YEAR_LAST_DATE = "pre_year_last_date";// 日变量：上一年最后一天
    public static final String  PARTITIONKEY_YEAR_400 = "partitionkey_year_400";// 日变量：当前日对应上一年同期的400分区
    public static final String  PRE1_MON_NUMBER12_CC = "pre1_mon_number12_cc";// 月变量：上1个月对应的12分区
    public static final String  PRE2_MON_NUMBER12_CC = "pre2_mon_number12_cc";// 月变量：上2个月对应的12分区
    public static final String  PRE3_MON_NUMBER12_CC = "pre3_mon_number12_cc";// 月变量：上3个月对应的12分区
    public static final String  PRE4_MON_NUMBER12_CC = "pre4_mon_number12_cc";// 月变量：上4个月对应的12分区
    public static final String  PRE5_MON_NUMBER12_CC = "pre5_mon_number12_cc";// 月变量：上5个月对应的12分区
    public static final String  V_FIVE_YEAR_PRE4 = "v_five_year_pre4";// 月变量：上4个月对应的五年分区
    public static final String  V_FIVE_YEAR_PRE5 = "v_five_year_pre5";// 月变量：上5个月对应的五年分区
    public static final String  V_FIVE_YEAR_PRE6 = "v_five_year_pre6";// 月变量：上6个月对应的五年分区
}
