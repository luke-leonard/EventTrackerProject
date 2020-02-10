## EventTracker Project
### Skill-Distillery Week 12

### Description
The event tracker is the generic name for a Spring Rest C.R.U.D. API. My event tracker is an api to request different coding languages and their information. Given a request to my api, I will return a list of languages and language details to match your needs.

Included are some post man tests to try testing the mappings.

### Paths  

| Return Type (JSON)| Route                     | Functionality                      |
|-------------------|---------------------------|------------------------------------|
| `List<Language>`  |`GET api/languages`        | Gets all Languages                 |
| `Language`        |`GET api/languages/{id}`   | Gets one Language by id            |
| `Language`        |`POST api/languages`       | Creates a new Language             |
| `Language`        |`PUT api/languages/{id}`   | Replaces an existing Language by id|
| `Boolean`         |`DELETE api/languages/{id}`| Deletes an existing Language by id |


### Technologies Used
* Spring Rest
* Spring Data JPA
* Spring Tool Suite
* J-Unit Jupiter
* JSON
* PostMan
* HTTP
* AWS
* Gradle (unfortunatly)

### Mistake Made / Lessons Learned
Somehow I put `includeFlat = "JPAproject"`
NOT `includeFlat "JPAproject"`
and that was gross to figure out. It looked so close to right so it was almost impossible to find.
This isn't a very large mistake but it cause me to search my project line by line and I even reinstalled my gradle wrappers cause that was the error that actually came up.
I need to put this here simply to remind myself never to do that again.

Anyway... I ended up preforming a very simple api with one non interesting table. I had J-unit tests and those actually did help me find an incorrect mapping.

Other than that, it was rather uneventful.

### Future Implementation
I would like to implement httpRequest remapping, but I was able to get all status codes working for all possible conditions.

I of course need to add some more data to my database. Hopefully I can do that in tandem with finishing my portfolio site. I feel these topics pair well together.

And finally, I would like to add more tables and endpoints. I actually do have another table and entity mapping for libraries and documentation for the different languages. I have yet to add the endpoints for them but that should be soon to come.
