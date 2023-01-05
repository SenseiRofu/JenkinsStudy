// Set up variables for the build
def branch = env.BRANCH_NAME
def buildNumber = env.BUILD_NUMBER

// Print a message to the console
println "Building branch ${branch} with build number ${buildNumber}"

// Check out code from the repository
checkout scm

// Run the build script
sh './build.sh'

// If the build is successful, upload the artifacts to a specified location
if (currentBuild.result == 'SUCCESS') {
  uploadArtifacts 'build/*.zip'
}
