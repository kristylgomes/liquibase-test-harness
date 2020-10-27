package liquibase.sdk.test.util


import liquibase.sdk.test.config.TestConfig
import liquibase.util.StreamUtil

class FileUtils {

    static String getFileContent(String changeObject, String databaseShortName, Integer databaseMajorVersion, Integer databaseMinorVersion, String expectedFolder, String fileExtension) {
        def resourceAccessor = TestConfig.instance.resourceAccessor

        def content = resourceAccessor.openStream(null, expectedFolder + "/" + databaseShortName + "/" + databaseMajorVersion + "/" + changeObject + fileExtension)
        if (content != null) {
            return StreamUtil.readStreamAsString(content)
        }

        content = resourceAccessor.openStream(null, expectedFolder + "/" + databaseShortName + "/" + changeObject + fileExtension)
        if (content != null) {
            return StreamUtil.readStreamAsString(content)
        }

        content = resourceAccessor.openStream(null, expectedFolder + "/" + changeObject + fileExtension)
        if (content != null) {
            return StreamUtil.readStreamAsString(content)
        }

        return null
    }
}
