# ThreatWindsJavaSDK
## Description
It's a set of tools developed in Java (using JDK 11), to interact with ThreatWinds RestFul services API.

## Project Structure

`/src/*` structure follows default Java structure. Every package, have a file called `package-info.java` inside, that 
have information about what it's use.

### Project Environment Variables (Very Important)
The SDK uses some environment variables that you must create to ensure the correct functioning.

-`TW_API_URL` - (`Required`) Represents the threat intelligence endpoints URL (Without ending `/`)

-`TW_API_KEY` - (`Required`) Represents the access key to the threat intelligence endpoints URL (`TW_API_URL`)

-`TW_API_SECRET` - (`Required`) Represents the access secret for threat intelligence endpoints URL (`TW_API_URL`)
