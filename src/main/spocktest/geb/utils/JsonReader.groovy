package spocktest.geb.utils

import groovy.json.JsonSlurper

/**
 * Class for Json Reader
 *
 * @author: Renalyn Arguelles
 */
class JsonReader {

    /**
     * Get credentials from json file
     *
     * @param category of the credentials
     * @param key of the string
     * @return string value
     */
    static String getCredentials (String category, String key) {
        String projDir = new File(System.getProperty("user.dir")).toPath()
        def reader = new BufferedReader(new InputStreamReader(new FileInputStream("${projDir}/src/main/resources/credentials.json")))
        def parsed = new JsonSlurper().parse(reader)
        return parsed."$category"."$key"
    }
}
