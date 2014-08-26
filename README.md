==Spring Data Issue==

Hi!

This test project exposes a issue that started to show up in spring-data-mongodb when I migrated from 1.3.2 to 1.5.2. The MongoDB driver itself does not have this problem. 

Check out the test com.acme.MappingIssueTest

This test loads the src/main/resources/source-data.json file into mongo and then attempts to read it out with Spring.
It results in a error of:

Given DBObject must be a BasicDBObject! Object of class [com.mongodb.BasicDBList] must be an instance of class com.mongodb.BasicDBObject

I believe this is on the structure inside of GeoPointValue.

There are three branches of this repo:

1. 132: works file on 1.3.2
2. master: Broken on 1.5.2
3. 160rc1: Still broken on 1.6.0.RC1
