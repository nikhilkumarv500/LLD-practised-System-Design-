# Compile and run Java program with file I/O redirection
# Create bin directory if it doesn't exist
if (!(Test-Path "bin")) {
    New-Item -ItemType Directory -Path "bin"
}

# Compile Java files to bin directory
javac -d bin *.java
if ($LASTEXITCODE -eq 0) {
    # Run from bin directory with classpath
    Get-Content input.txt | java -cp bin Code | Out-File -FilePath output.txt -Encoding UTF8
    Write-Host "Program executed successfully!"
    Write-Host "Class files created in bin/ directory"
    Write-Host "Input was read from input.txt"
    Write-Host "Output was written to output.txt"
} else {
    Write-Host "Compilation failed!"
}