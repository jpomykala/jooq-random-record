
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
GNU General Public License v3.0
