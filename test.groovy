// Create the job
def job = new Job("MyJob", "jenkins")

// Set up variables for the build
def branch = env.main
def buildNumber = env.BUILD_NUMBER

// Add build steps to the job
job.addBuildStep(new Shell("echo 'Building branch with build number ${buildNumber}'"))
job.addBuildStep(new Checkout("git", "https://github.com/SenseiRofu/JenkinsStudy.git"))
job.addBuildStep(new Shell("./build.sh"))

// If the build is successful, upload the artifacts to a specified location
job.addPostBuildStep(new ArtifactoryPublisher("build/*.zip", "releases", "https://artifactory.example.com/artifactory"))

// Save the job
job.save()
