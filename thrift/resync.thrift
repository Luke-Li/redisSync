namespace java com.kd.tools.redissync.thrift
 
service  RedisSyncService {
  //增量同步数据
  string sync(1:string sync_job_name);
  //全量同步数据
  string resync(1:string sync_job_name);
}
