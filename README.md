## Demonstrates a BigQuery Remote function in Java

```shell
bq mk --connection --location=us-west1 --project_id=myproject \
    --connection_type=CLOUD_RESOURCE sample-remote-fn-conn
```

```shell
bq show --connection myproject.us-west1.sample-remote-fn-conn
```

```sql
CREATE FUNCTION `myproject.mydataset`.capitalize(x STRING) RETURNS STRING
REMOTE WITH CONNECTION `myproject.us-west1.sample-remote-fn-conn`
OPTIONS (
  endpoint = 'https://cloudrun-endpoint-url'
)
```