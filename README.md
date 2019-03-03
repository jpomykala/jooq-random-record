
### jOOQ random record


Example usage
```java
CompanyRecord randomize = RandomJooq.randomize(CompanyRecord.class);

assertThat(randomize.getId()).isNotNull();
assertThat(randomize.getName()).isNotNull();
assertThat(randomize.getExipreOn()).isNotNull();
assertThat(randomize.getDemo()).isNotNull();
assertThat(randomize.getTaxId()).isNotNull();
assertThat(randomize.getLegalName()).isNotNull();
assertThat(randomize.getCreated()).isNotNull();
```

Installation
```xml
//waiting for OSHR
```
