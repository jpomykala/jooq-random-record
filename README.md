
### jOOQ random record


### What is jooq-random-record?

`jooq-random-record` is a library that generates random Java beans, simmilar to the existing one [random-beans](https://github.com/benas/random-beans) but built especially for `jooq` records! Let's say you have a class `CompanyRecord` generated by jooq and you want to generate a random instance of it, here we go:

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

Let's see another example. If you want to generate a random stream of 10 `CompanyRecord`s, you can use the following snippet:

```java
List<CompanyRecord> output = RandomJooq.randomizeList(10, CompanyRecord.class);
```

Installation
```xml
<dependency>
  <groupId>com.jpomykala</groupId>
  <artifactId>jooq-random-record</artifactId>
  <version>0.0.1</version>
</dependency>
```

# Contribution

Would you like to add something or improve source? Create new issue, let's discuss it 

- **If in doubt, please discuss your ideas first before providing a pull request. This often helps avoid a lot of unnecessary work. In particular, we might prefer not to prioritise a particular feature for another while.**
- Fork the repository.
- The commit message should reference the issue number.
- Check out and work on your own fork.
- Try to make your commits as atomic as possible. Related changes to three files should be committed in one commit.
- Try not to modify anything unrelated.


# More
- Follow me on [Twitter](https://twitter.com/jakub_pomykala) :)
- Check out my [website](https://jpomykala.github.io)

# License
The MIT License
